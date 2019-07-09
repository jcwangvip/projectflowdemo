package com.example.springbootdemo.permission.form;

import lombok.Data;

/**
 * 角色表单页面
 *
 * @author jiancheng
 * @date 2019-7-3
 */
@Data
public class RoleForm {

//    private String code;
    private String name;
    private String memo;
    private Long parentId;


}
