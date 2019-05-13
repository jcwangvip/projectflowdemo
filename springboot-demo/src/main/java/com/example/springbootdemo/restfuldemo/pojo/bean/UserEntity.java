package com.example.springbootdemo.restfuldemo.pojo.bean;

import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "biz_user")
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer age;


	public UserEntity() {}

	public UserEntity(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public static UserEntity build(UserForm userForm) {
		return new UserEntity(userForm.getName(),userForm.getAge());
	}
}
