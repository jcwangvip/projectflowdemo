package com.jc.logservice.service;

import com.jc.logservice.service.imp.InterfaceLogServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@WebAppConfiguration
@SpringBootTest
@Slf4j
public class ExecuteLogServiceTest {


    @Autowired
    ExecuteLogService executeLogService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void execute() {
        executeLogService.setLogService(new InterfaceLogServiceImpl());
        Assert.assertNotEquals(executeLogService, null);
        String result = executeLogService.execute();
        System.out.println(result);
    }
}