package com.jc.logservice.repository;

import com.jc.logservice.entity.LogEntity;

public class InterfaceLogRepository {

    public void save(LogEntity logEntity) {
        System.out.println("InterfaceLogRepository执行保存" + logEntity);
    }
}
