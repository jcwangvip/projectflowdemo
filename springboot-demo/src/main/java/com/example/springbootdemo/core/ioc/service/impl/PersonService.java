package com.example.springbootdemo.core.ioc.service.impl;

import com.example.springbootdemo.core.ioc.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-12-7
 */
@Slf4j
@Service
public class PersonService extends AbstractService {

    private String type = "person";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void mySelf() {
        log.info("我是人类代表");
    }


}
