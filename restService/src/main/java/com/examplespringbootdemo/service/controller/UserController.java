package com.examplespringbootdemo.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户操作
 *
 * @author jiancheng
 */
@RestController
public class UserController {


    @RequestMapping("hello")
    public String hello() {
        return "hello word";
    }

    @GetMapping("/nameHello")
    public String hello(String name) {
        return name + " : hello word";
    }


}
