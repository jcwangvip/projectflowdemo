package com.example.springbootdemo.rest.restfuldemo.permission.service;


import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.rest.restfuldemo.permission.bean.RoleEntity;
import com.example.springbootdemo.rest.restfuldemo.permission.form.RoleForm;

/**
 * 角色服务
 *
 * @author jiancheng
 * @date 2019-7-3
 */
public interface RoleService {

    ResultVO<RoleEntity> save(RoleForm roleForm);
}
