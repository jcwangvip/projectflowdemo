package com.example.springbootdemo.restfuldemo.service;

import com.example.springbootdemo.restfuldemo.data.UserFormData;
import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * service测试
 *
 * @author jiancheng
 * @date 2019-5-13
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImplTest.class);
    @Autowired
    UserService userService;

    public UserServiceImplTest() {
    }

    @Before
    public void setUp() throws Exception {
        log.info("开始");
        log.info("userService {}", this.userService);
    }

    @After
    public void tearDown() throws Exception {
        log.info("结束");
    }

    @Test
    public void save() {
        UserForm userForm = UserFormData.getUserForm();
        UserEntity userEntity = this.userService.save(userForm);
        Assert.assertEquals(userEntity.getName(), userForm.getName());
    }
}
