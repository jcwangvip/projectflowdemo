package com.jc.integrated.elasticsearch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2020-1-3
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello word";
    }

}
