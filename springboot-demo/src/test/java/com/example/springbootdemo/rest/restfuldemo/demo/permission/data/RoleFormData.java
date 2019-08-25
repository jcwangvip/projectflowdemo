package com.example.springbootdemo.rest.restfuldemo.demo.permission.data;

import com.example.springbootdemo.rest.restfuldemo.demo.permission.form.RoleForm;

/**
 * Role数据
 *
 * @author jiancheng
 * @date 2019-7-9
 */
public class RoleFormData {


    public static RoleForm build(Long parentId, String name, String memo) {
        RoleForm roleForm = new RoleForm();
        roleForm.setName(name);
        roleForm.setMemo(memo);
        roleForm.setParentId(parentId);
        return roleForm;
    }
}
