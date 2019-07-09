package com.example.springbootdemo.permission.service;


import com.example.springbootdemo.common.ResultVO;
import com.example.springbootdemo.permission.bean.RoleEntity;
import com.example.springbootdemo.permission.form.RoleForm;

/**
 * 角色服务
 *
 * @author jiancheng
 * @date 2019-7-3
 */
public interface RoleService {

    ResultVO<RoleEntity> save(RoleForm roleForm);
}
