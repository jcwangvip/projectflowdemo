package com.example.springbootdemo.restfuldemo.service.impl;


import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;
import com.example.springbootdemo.restfuldemo.repository.UserRepository;
import com.example.springbootdemo.restfuldemo.service.UserService;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
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
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public UserEntity save(UserForm userForm) {
        return userRepository.save(UserEntity.build(userForm));
    }


    @Transactional
    @Override
    public UserEntity update(UserForm userForm) {
        UserEntity userEntity = userRepository.getOne(userForm.getId());
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
