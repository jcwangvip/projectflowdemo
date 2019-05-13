package com.example.springbootdemo.restfuldemo.data;

import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-5-13
 */
public class UserFormData {
    public UserFormData() {
    }

    public static UserForm getUserForm() {
        UserForm userForm = new UserForm();
        userForm.setName("zhangsan");
        userForm.setAge(10);
        return userForm;
    }
}