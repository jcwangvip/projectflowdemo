package com.example.springbootdemo.restfuldemo.repository;


import com.example.springbootdemo.restfuldemo.pojo.bean.QUserEntity;
import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * UserRepository
 *
 * @author jiancheng
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, QuerydslPredicateExecutor<UserEntity> {


    /**
     * 根据名称和年龄查询
     * @param name
     * @param age
     * @return
     */
	List<UserEntity> findByNameAndAge(String name, Integer age);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    UserEntity findOneById(Long id);

    /**
     * 多条件查询
     * @param userForm
     * @param last
     * @return
     */
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
