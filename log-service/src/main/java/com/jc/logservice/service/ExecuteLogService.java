package com.jc.logservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 执行服务
 *
 * @author jcwang
 */
@Service
@Slf4j
public class ExecuteLogService {

    private LogService logService;

//    public ExecuteLogService(LogService logService) {
////        this.logService = logService;
//    }


    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    public String execute() {
        return logService.save();
    }

}
