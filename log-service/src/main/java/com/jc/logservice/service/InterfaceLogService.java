package com.jc.logservice.service;

import com.jc.logservice.entity.LogEntity;

public interface InterfaceLogService extends LogService {

    String save(LogEntity logEntity);

}
