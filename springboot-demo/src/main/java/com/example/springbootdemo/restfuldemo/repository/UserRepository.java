package com.example.springbootdemo.restfuldemo.repository;


import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.po.QUserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.util.StringUtils;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long>, QuerydslPredicateExecutor<UserEntity> {


	List<UserEntity> findByNameAndAge(String name, Integer age);

    UserEntity findOneById(Long id);

	static BooleanExpression getBooleanExpression(UserForm userForm, BooleanExpression last) {
		if (userForm.getId() != null) {
			last = last.and(QUserEntity.userEntity.id.eq(userForm.getId()));
		}
        if (!StringUtils.isEmpty(userForm.getName())) {
            last = last.and(QUserEntity.userEntity.name.eq(userForm.getName()));
        }
        if (userForm.getAge() != null) {
            last = last.and(QUserEntity.userEntity.age.eq(userForm.getAge()));
        }
		return last;
	}


}
