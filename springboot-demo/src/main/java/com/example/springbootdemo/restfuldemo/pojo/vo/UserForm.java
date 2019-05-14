package com.example.springbootdemo.restfuldemo.pojo.vo;

import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 页面值对象
 *
 * @author jiancheng
 */
@Data
public class UserForm {

    private Long id;
    //    @NotNull(message = "name不能为空")
    @NotNull(message = "restfulDemo.userController.userForm.name.null")
    private String name;
    @Range(min = 0, max = 150, message = "年龄必须是0到150之间的正整数")
    private Integer age;


    public UserForm() {
    }

    public UserForm(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public static UserEntity build(UserForm userForm) {
        return new UserEntity(userForm.getName(), userForm.getAge());
    }
}
