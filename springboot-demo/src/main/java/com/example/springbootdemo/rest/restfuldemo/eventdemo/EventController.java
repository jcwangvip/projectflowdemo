package com.example.springbootdemo.rest.restfuldemo.eventdemo;

import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.common.vo.ResultVOBuilder;
import com.example.springbootdemo.rest.restfuldemo.demo.demo.pojo.vo.UserForm;
import com.example.springbootdemo.spring.springframework.context.ApplicationEventPublisherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-9-7
 */
@RestController
public class EventController {

    @Autowired
    private ApplicationEventPublisherService service;

    /**
     * 新增
     *
     * @param userForm
     * @return
     */
    @PostMapping("event/eventPublisher")
    public ResultVO<UserForm> saveByResultVo(@RequestBody UserForm userForm) throws JsonProcessingException {
        service.publisher();
        return ResultVOBuilder.success(userForm);
    }

}
