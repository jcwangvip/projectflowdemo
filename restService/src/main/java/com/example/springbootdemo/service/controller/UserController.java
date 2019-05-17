package com.example.springbootdemo.service.controller;

import com.example.springbootdemo.service.vo.HelloVO;
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

    @RequestMapping("/nameHello")
    public String hello(HelloVO helloVO) {
        return "hello word" + helloVO.toString();
    }


}
