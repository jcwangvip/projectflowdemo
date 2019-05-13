package com.example.springbootdemo.restfuldemo.service;


import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;

import java.util.List;


public interface UserService {

    UserEntity save(UserForm userForm);

    UserEntity update(UserForm userForm);

    UserEntity findOneById(Long id);

    void delete(Long id);

    List<UserEntity> findByUserForm(UserForm userForm);
}
