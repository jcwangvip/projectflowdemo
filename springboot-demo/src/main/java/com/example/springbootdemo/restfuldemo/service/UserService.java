package com.example.springbootdemo.restfuldemo.service;


import com.example.springbootdemo.common.ResultVO;
import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 服务层
 *
 * @author jiancheng
 */
public interface UserService {

    ResultVO<UserEntity> saveByResultVo(UserForm userForm, int stattus);

    UserEntity save(UserForm userForm);

    UserEntity saveById(Long id);

    UserEntity update(UserForm userForm);

    UserEntity findOneById(Long id);

    void delete(Long id);

    List<UserEntity> findByUserForm(UserForm userForm);

}
