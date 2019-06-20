package com.jc.logservice.service.imp;

import com.jc.logservice.service.LogService;
import com.jc.logservice.vo.LogVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogServiceImpl implements LogService, LogVO {

    @Override
    public String save() {
        return "当前执行的是LogServiceImpl";
    }

    @Override
    public LogService getLogService() {
        return this;
    }
}
