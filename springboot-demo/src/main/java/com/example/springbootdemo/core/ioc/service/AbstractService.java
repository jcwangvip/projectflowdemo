package com.example.springbootdemo.core.ioc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 抽象类
 *
 * @author jiancheng
 * @date 2019-12-7
 */
@Slf4j
@Service
public abstract class AbstractService implements SuperService {

    private String type = "abstractService";

    public String getType() {
        return type;
    }

    private void say() {
        log.info("我是抽象服务类");
    }

    public abstract void mySelf();

}
