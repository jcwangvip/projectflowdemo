package com.example.springbootdemo.rest.restfuldemo.demo.permission.repository;


import com.example.springbootdemo.rest.restfuldemo.demo.permission.bean.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-7-3
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, QuerydslPredicateExecutor<UserEntity> {

    /**
     * 根据code查询用户信息
     *
     * @param code
     * @return
     */
    UserEntity findByCode(String code);
}
