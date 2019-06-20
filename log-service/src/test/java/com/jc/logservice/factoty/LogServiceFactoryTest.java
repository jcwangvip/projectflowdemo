package com.jc.logservice.factoty;

import com.jc.logservice.service.LogService;
import com.jc.logservice.service.imp.LogServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogServiceFactoryTest {


    LogServiceFactory logServiceFactory;

    @Before
    public void setUp() throws Exception {
        logServiceFactory = LogServiceFactory.createLogServiceFactory();
        Assert.assertNotNull(logServiceFactory);
    }

    @Test
    public void createLogService() {
        LogService logService = logServiceFactory.createLogService(LogServiceImpl::new);
        String result = logService.save();
        System.out.println(result);
    }
}