package com.jc.logservice.factoty;

import com.jc.logservice.service.LogService;
import com.jc.logservice.vo.LogVO;

public class LogServiceFactory {

    private LogServiceFactory() {
    }

    public static LogServiceFactory createLogServiceFactory() {
        return new LogServiceFactory();
    }

    public LogService createLogService(LogVO logVO){
        return logVO.getLogService();
    }
}
