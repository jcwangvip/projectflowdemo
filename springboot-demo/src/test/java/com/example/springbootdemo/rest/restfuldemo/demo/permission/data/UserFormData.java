package com.example.springbootdemo.rest.restfuldemo.demo.permission.data;


import com.example.springbootdemo.rest.restfuldemo.demo.permission.form.UserForm;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.form.UserUpdateForm;

import java.util.Arrays;

/**
 * 用户数据类
 *
 * @author jiancheng
 * @date 2019-7-5
 */
public class UserFormData {



    public static UserUpdateForm buildUserUpdateForm() {
        UserUpdateForm userUpdateForm = new UserUpdateForm();
        userUpdateForm.setId(1L);
        userUpdateForm.setName("修改名称");
        userUpdateForm.setRoleId(2L);
        return userUpdateForm;
    }

    public static UserForm buildUserForm() {
        UserForm userForm = new UserForm();
        userForm.setCode("zhangsan");
        userForm.setName("张三");
        userForm.setRoleIdList(Arrays.asList(1L));
        userForm.setMemo("测试保存用户");
        return userForm;
    }

}
