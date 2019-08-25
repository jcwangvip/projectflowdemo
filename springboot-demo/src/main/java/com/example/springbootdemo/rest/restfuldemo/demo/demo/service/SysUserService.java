package com.example.springbootdemo.rest.restfuldemo.demo.demo.service;


import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.rest.restfuldemo.demo.demo.pojo.bean.UserEntity;
import com.example.springbootdemo.rest.restfuldemo.demo.demo.pojo.vo.UserForm;

import java.util.List;

/**
 * 服务层
 *
 * @author jiancheng
 */
public interface SysUserService {

    ResultVO<UserEntity> saveByResultVo(UserForm userForm, int stattus);

    UserEntity save(UserForm userForm);

    UserEntity saveById(Long id);

    UserEntity update(UserForm userForm);

    UserEntity findOneById(Long id);

    void delete(Long id);

    List<UserEntity> findByUserForm(UserForm userForm);

}
