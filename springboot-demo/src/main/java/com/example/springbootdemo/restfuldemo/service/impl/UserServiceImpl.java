package com.example.springbootdemo.restfuldemo.service.impl;


import com.example.springbootdemo.common.ResultVO;
import com.example.springbootdemo.common.ResultVOBuilder;
import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;
import com.example.springbootdemo.restfuldemo.repository.UserRepository;
import com.example.springbootdemo.restfuldemo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 服务类
 *
 * @author jiancheng
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ResultVOBuilder resultVOBuilder;
    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    @Override
    public ResultVO<UserEntity> saveByResultVo(UserForm userForm, int stattus) {
        UserEntity userEntity = userRepository.save(UserEntity.build(userForm));
        try {
            log.info("保存完的数据为{}", objectMapper.writeValueAsString(userEntity));
        } catch (JsonProcessingException e) {
            log.error("json 序列化对象的时候异常{}", e);
        }
        if (1 == stattus) {
            return resultVOBuilder.failure("报错异常,查看事务是否会回滚");
        }
        if (2 == stattus) {
            throw new RuntimeException("这里抛出运行时异常,会被谁捕捉到");
        }

        List<UserEntity> userEntityList = userRepository.findAll();
        if (userEntityList != null) {
            log.info("当前查询的所有数据为空");
            return ResultVOBuilder.success(userEntityList.get(0));
        }
        return ResultVOBuilder.success(null);
    }


    @Transactional
    @Override
    public UserEntity save(UserForm userForm) {
        UserEntity userEntity = userRepository.save(UserEntity.build(userForm));
        return userEntity;
    }


    @Transactional
    @Override
    public UserEntity update(UserForm userForm) {
        UserEntity userEntity = userRepository.getOne(userForm.getId());
        if (userEntity == null){
            return null;
        }
        return userRepository.save(UserEntity.build(userForm));
    }

    @Override
    public UserEntity findOneById(Long id) {
        return userRepository.findOneById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        UserEntity userEntity = userRepository.findOneById(id);
        if (userEntity != null) {
            userRepository.delete(userEntity);
        }
    }

    @Override
    public List<UserEntity> findByUserForm(UserForm userForm) {
        BooleanExpression last = Expressions.asBoolean(true).isTrue();
        last = UserRepository.getBooleanExpression(userForm, last);
        List<UserEntity> userEntityList = (List<UserEntity>) userRepository.findAll(last);
        return userEntityList;
    }


}
