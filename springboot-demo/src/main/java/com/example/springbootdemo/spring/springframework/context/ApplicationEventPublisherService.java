package com.example.springbootdemo.spring.springframework.context;

import com.example.springbootdemo.rest.restfuldemo.demo.demo.pojo.vo.UserForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 事件demo
 *
 * @author jiancheng
 * @date 2019-9-7
 */
@Slf4j
@Component
public class ApplicationEventPublisherService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publisher() throws JsonProcessingException {
        log.info("当前进入事件publisher方法");
        UserForm userForm = new UserForm();
        userForm.setId(1L);
        userForm.setName("zhangsan");
        userForm.setAge(6);
        log.info("准备publisher,对象{}", objectMapper.writeValueAsString(userForm));
        applicationEventPublisher.publishEvent(userForm);
        log.info("publisher 的方法完毕");
    }


}
