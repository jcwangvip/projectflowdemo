package com.example.springbootdemo.rest.restfuldemo.permission.form;

import lombok.Data;

/**
 * 角色表单页面
 *
 * @author jiancheng
 * @date 2019-7-3
 */
@Data
public class RoleForm {

    private String name;
    private String memo;
    private Long parentId;


}
