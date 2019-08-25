package com.example.springbootdemo.rest.restfuldemo.demo.permission.form;

import com.example.springbootdemo.rest.restfuldemo.demo.permission.bean.RoleEntity;
import lombok.Data;

import javax.persistence.Transient;

/**
 * 用户更新表单类
 *
 * @author jiancheng
 * @date 2019-7-5
 */
@Data
public class UserUpdateForm {

    private Long id;

    private String name;
    private String phone;
    private String mailBox;
    private Long roleId;
    private String memo;

    @Transient
    private RoleEntity roleEntity;

}
