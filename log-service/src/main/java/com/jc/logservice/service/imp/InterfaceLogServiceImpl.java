package com.jc.logservice.service.imp;

import com.jc.logservice.entity.InterfaceLogEntity;
import com.jc.logservice.entity.LogEntity;
import com.jc.logservice.repository.InterfaceLogRepository;
import com.jc.logservice.service.InterfaceLogService;
import com.jc.logservice.service.LogService;
import com.jc.logservice.vo.LogVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 接口日志实现类
 *
 * @author jcwang
 */
@Service
@Slf4j
public class InterfaceLogServiceImpl implements InterfaceLogService, LogVO {

    @Autowired
    private InterfaceLogRepository interfaceLogRepository;

//    public InterfaceLogServiceImpl() {
//        this.interfaceLogRepository = new InterfaceLogRepository();
//    }

    @Override
    public String save() {
        return "当前执行的是InterfaceLogServiceImpl";
    }

    @Override
    public String save(LogEntity logEntity) {
        InterfaceLogEntity interfaceLogEntity = (InterfaceLogEntity) logEntity;
        interfaceLogRepository.save(interfaceLogEntity);
        return "当前执行的是InterfaceLogServiceImpl,save有参数方法";
    }

    @Override
    public LogService getLogService() {
        return this;
    }
}
