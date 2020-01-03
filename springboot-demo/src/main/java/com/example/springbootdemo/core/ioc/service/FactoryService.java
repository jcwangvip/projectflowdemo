package com.example.springbootdemo.core.ioc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-12-7
 */
@Slf4j
@Service
public class FactoryService {

    private Map<String, AbstractService> map = new HashMap<>();

    private List<AbstractService> services;

    public FactoryService(List<AbstractService> services) {
        this.services = services;
        services.forEach(s -> map.put(s.getType(), s));
        log.info("当前收集到的map信息{}",map.keySet());
    }
}
