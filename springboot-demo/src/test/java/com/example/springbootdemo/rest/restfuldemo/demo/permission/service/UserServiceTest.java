package com.example.springbootdemo.rest.restfuldemo.demo.permission.service;

import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.bean.UserEntity;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.data.UserFormData;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.form.UserForm;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-7-9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(userService);
    }

    @Test
    public void test() {
        int i = 1;
        int j = i++;
        if (i == (++j) && (i++) == j) {
            i += j;
        }
        System.out.println("i= " + i);
    }

    @Test
    public void find() {
        List<UserEntity> userEntityList = userRepository.findAll();

        UserEntity asdf = userRepository.findByCode("asdf");
        log.info("sdf");

    }

    @Test
    public void t1_save() {
        log.info("开始执行t1_save方法");
        UserForm userForm = UserFormData.buildUserForm();
        ResultVO<UserEntity> userEntityResultVO = userService.save(userForm);
        if (!userEntityResultVO.isSuccess()) {
            log.info("保存失败{}", userEntityResultVO);
            Assert.assertTrue(false);
        }

    }

    @Test
    public void t2_update() {
        log.info("开始执行t2_update方法");
    }


}