package com.example.springbootdemo.restfuldemo.pojo.vo;

import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import lombok.Data;

/**
 * 页面值对象
 *
 * @author jiancheng
 */
@Data
public class UserForm {

	private Long id;
	private String name;
	private Integer age;


	public UserForm() {}

	public UserForm(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public static UserEntity build(UserForm userForm) {
		return new UserEntity(userForm.getName(),userForm.getAge());
	}
}
