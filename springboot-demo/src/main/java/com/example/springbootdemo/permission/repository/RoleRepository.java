package com.example.springbootdemo.permission.repository;


import com.example.springbootdemo.permission.bean.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-7-3
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long>, QuerydslPredicateExecutor<RoleEntity> {

    /**
     * 根据父节点查询当前信息
     *
     * @param parentId 父节点
     * @return 角色信息
     */
    RoleEntity findByParentId(Long parentId);

    /**
     * 根据code查询
     *
     * @param code itCode
     * @return role实体
     */
    RoleEntity findByCode(String code);

    /**
     * 根据name查询
     *
     * @param name
     * @return
     */
    RoleEntity findByName(String name);
}
