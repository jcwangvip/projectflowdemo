package com.example.springbootdemo.permission.service;


import com.example.springbootdemo.common.ResultVO;
import com.example.springbootdemo.permission.bean.UserEntity;
import com.example.springbootdemo.permission.form.UserForm;
import com.example.springbootdemo.permission.form.UserUpdateForm;

/**
 * 用户服务类
 *
 * @author jiancheng
 * @date 2019-7-4
 */
public interface UserService {


    /**
     * 更新
     *
     * @param userUpdateForm 表单对象
     * @return 封装后的用户实体
     */
    ResultVO<UserEntity> update(UserUpdateForm userUpdateForm);

    /**
     * 保存用户信息
     *
     * @param userForm 用户表单对象
     * @return 封装后的用户实体
     */
    public ResultVO<UserEntity> save(UserForm userForm);
}
