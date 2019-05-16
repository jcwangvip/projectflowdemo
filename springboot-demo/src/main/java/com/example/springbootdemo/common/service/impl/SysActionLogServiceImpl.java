package com.example.springbootdemo.common.service.impl;

import com.example.springbootdemo.common.entity.SysActionLog;
import com.example.springbootdemo.common.repository.SysActionLogRepository;
import com.example.springbootdemo.common.service.SysActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统日志服务实现类
 *
 * @author jiancheng
 * @date 2019-5-14
 */
@Service
public class SysActionLogServiceImpl implements SysActionLogService {

    @Autowired
    private SysActionLogRepository sysActionLogRepository;

    /**
     * 新增日志
     *
     * @param sysActionLog sysActionLog
     */
    @Override
    public SysActionLog addSysActionLog(SysActionLog sysActionLog) {
        return sysActionLogRepository.save(sysActionLog);
    }


}
