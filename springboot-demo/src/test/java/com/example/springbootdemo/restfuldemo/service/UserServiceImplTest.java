package com.example.springbootdemo.restfuldemo.service;

import com.example.springbootdemo.common.ResultVO;
import com.example.springbootdemo.restfuldemo.data.UserFormData;
import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;
import com.example.springbootdemo.restfuldemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * service测试
 *
 * @author jiancheng
 * @date 2019-5-13
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {


    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

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
    public void saveTransactional() {
        try {
            UserForm userForm = UserFormData.getUserForm();
            UserEntity userEntity = this.userService.save(userForm);
            UserEntity userEntity1 = this.userService.save(userForm);
            Assert.assertEquals(userEntity.getName(), userForm.getName());
        } catch (Exception e) {
            log.error("发生异常{}", e);
            List<UserEntity> userEntityList1 = userRepository.findAll();
            assert userEntityList1.size() == 0;
        }
    }


    @Test
    public void save() {
        UserForm userForm = UserFormData.getUserForm();
        UserEntity userEntity = this.userService.save(userForm);
        Assert.assertEquals(userEntity.getName(), userForm.getName());
    }

    @Test
    public void saveByResultVo() {
        UserForm userForm = UserFormData.getUserForm();
        int status = 1;
        ResultVO<UserEntity> userEntityResultVO = this.userService.saveByResultVo(userForm, status);
        Assert.assertEquals(userEntityResultVO.isSuccess(), false);
        List<UserEntity> userEntityList = userRepository.findAll();
        log.info("userEntityList = {}", userEntityList);
        // 不要这样验证,别的地方也有可能保存了数据,所以这样单跑这个测试是没问题的,但是package的时候打印出来就是大于0的
        // assert userEntityList.size() == 0;

        try {
            ResultVO<UserEntity> userEntityResultVO1 = this.userService.saveByResultVo(userForm, status + 1);
            Assert.assertEquals(userEntityResultVO1.isSuccess(), true);
            List<UserEntity> userEntityList1 = userRepository.findAll();
            assert userEntityList1.size() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
