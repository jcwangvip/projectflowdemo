package com.example.springbootdemo.common.service;

import com.example.springbootdemo.common.entity.SysActionLog;

/**
 * 系统日志服务
 *
 * @author jiancheng
 * @date 2019-5-14
 */
public interface SysActionLogService {

    /**
     * 新增操作日志
     *
     * @param sysActionLog sysActionLog
     * @return SysActionLog
     */
    SysActionLog addSysActionLog(SysActionLog sysActionLog);
}
