package com.example.springbootdemo.rest.restfuldemo.demo.demo.pojo.bean;

import com.example.springbootdemo.rest.restfuldemo.demo.demo.pojo.vo.UserForm;
import lombok.Data;

import javax.persistence.*;

/**
 * 实体
 *
 * @author jiancheng
 */
@Data
@Entity
@Table(name = "biz_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;


    public UserEntity() {
    }

    public UserEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public static UserEntity build(UserForm userForm) {
        return new UserEntity(userForm.getName(), userForm.getAge());
    }
}
