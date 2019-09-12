package com.example.springbootdemo.spring.springframework.context.listener;

import com.example.springbootdemo.rest.restfuldemo.demo.demo.pojo.vo.UserForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 事件监听
 *
 * @author jiancheng
 * @date 2019-9-7
 */
@Service
@Slf4j
public class EventListenerDemo {

    @Autowired
    private ObjectMapper objectMapper;

    /*@EventListener
    public void listener(UserForm userForm) {
        log.info("进入用@EventListener标注的listener事件监听的方法");
        try {
            Thread.sleep(30000);
            log.info("listener收到的对象{}", objectMapper.writeValueAsString(userForm));
        } catch (Exception e) {
            log.error("listener异常{},{}", Thread.currentThread(), e);
        }
    }*/

    @Async
    @EventListener
    public void asyncListener(UserForm userForm) {
        log.info("进入用@EventListener标注的asyncListener事件监听的方法");
        try {
            Thread.sleep(60000);
            log.info("asyncListener收到的对象{}", objectMapper.writeValueAsString(userForm));
        } catch (Exception e) {
            log.error("asyncListener异常{},{}", Thread.currentThread(), e);
        }
    }


}
