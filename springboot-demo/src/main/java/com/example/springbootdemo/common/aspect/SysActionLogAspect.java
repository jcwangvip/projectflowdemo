package com.example.springbootdemo.common.aspect;

import com.example.springbootdemo.common.entity.SysActionLog;
import com.example.springbootdemo.common.service.SysActionLogService;
import com.example.springbootdemo.common.utils.IPUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统controller层日志记录
 *
 * @author jiancheng
 * @date 2019-5-14
 */
@Aspect
@Component
@Order(10)
@Slf4j
public class SysActionLogAspect {


    @Autowired
    private SysActionLogService sysActionLogService;
    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut("execution(public * com.example.springbootdemo.*.controller.*.*(..))")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //记录错误log
        SysActionLog sysLog = saveSysLog(point, beginTime);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        request.setAttribute("sysLog", sysLog);
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //保存日志
        SysActionLog sysActionLog = saveSysLog(point, time);
        //保存系统日志
        try {
            sysActionLogService.addSysActionLog(sysActionLog);
        } catch (Exception e) {
            log.info("记录日志失败");
        }
        return result;
    }

    private SysActionLog saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        SysActionLog sysLog = new SysActionLog();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ApiOperation ann = method.getAnnotation(ApiOperation.class);
        if (ann != null) {
            //注解上的描述
            sysLog.setOperation(ann.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        //请求的参数
        Object[] args = joinPoint.getArgs();
        try {
//            String params = JSON.toJSONString(args[0]);
            String params = objectMapper.writeValueAsString(args[0]);
            String s="login";
            if (! s.contains(methodName)) {
                sysLog.setParams(params);
            }
        } catch (Exception e) {
            log.error("参数处理异常{}",e);
        }
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        //用户名
        /*if (null != UserContext.getUser()) {
            String username = UserContext.getUser().getUsername();
            sysLog.setUsername(username);
            sysLog.setTenantId(UserContext.getUser().getTenantId());
        }*/
        sysLog.setTime(time);
        sysLog.setCreateDate(new Date());
        sysLog.setStatus(1);
        sysLog.setRequestUri(request.getRequestURL().toString());
        /*//获取浏览器信息
        Browser browser = UserAgent.parseUserAgentString(request.getHeader("User-Agent")).getBrowser();
        //获取浏览器版本号
        Version version = browser.getVersion(request.getHeader("User-Agent"));
        if (null != browser && null != version && null != browser.getName() && null != version.getVersion()) {
            String info = browser.getName() + "/" + version.getVersion();
            sysLog.setUserAgent(info);
        }*/
        request.setAttribute("sysLog", sysLog);
        return sysLog;
    }


}
