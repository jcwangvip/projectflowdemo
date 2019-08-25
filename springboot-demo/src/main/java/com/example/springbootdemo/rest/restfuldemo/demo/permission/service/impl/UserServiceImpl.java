package com.example.springbootdemo.rest.restfuldemo.demo.permission.service.impl;

import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.common.vo.ResultVOBuilder;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.bean.UserEntity;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.form.UserForm;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.form.UserUpdateForm;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.repository.RoleRepository;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.repository.UserRepository;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.service.UserService;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.bean.RoleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户服务实现类
 *
 * @author jiancheng
 * @date 2019-7-4
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ResultVOBuilder resultVOBuilder;


    @Transactional
    @Override
    public ResultVO<UserEntity> update(UserUpdateForm userUpdateForm) {
        UserEntity userEntity = userRepository.getOne(userUpdateForm.getId());
        if (userEntity != null) {
            return resultVOBuilder.failure("permission.userCode.notNull", "当前给定的用户不存在,无法修改", userUpdateForm.getId());
        }
        if (userUpdateForm.getRoleId() != null) {
            RoleEntity roleEntity = roleRepository.getOne(userUpdateForm.getRoleId());
            if (roleEntity == null) {
                return resultVOBuilder.failure("permission.roles.error", "修改的角色信息不存在");
            }
            userUpdateForm.setRoleEntity(roleEntity);
        }
        UserEntity saveUserEntity = userRepository.save(userEntity.build(userUpdateForm));
        return ResultVOBuilder.success(saveUserEntity);
    }


    @Transactional
    @Override
    public ResultVO<UserEntity> save(UserForm userForm) {
        UserEntity userEntity = userRepository.findByCode(userForm.getCode());
        if (userEntity != null) {
            return resultVOBuilder.failure("permission.userCode.notNull", "当前给定的用户code{}信息已存在,不要重复添加", userForm.getCode());
        }
        if (CollectionUtils.isEmpty(userForm.getRoleIdList())) {
            return resultVOBuilder.failure("permission.role.isNull", "增加的用户不能没有角色");
        }
        List<RoleEntity> roleEntityList = roleRepository.findAllById(userForm.getRoleIdList());
        if (CollectionUtils.isEmpty(roleEntityList)) {
            return resultVOBuilder.failure("permission.roles.error", "当前角色{}信息不存在");
        }
        if (roleEntityList.size() != userForm.getRoleIdList().size()) {
            List<Long> idList = roleEntityList.stream().map(RoleEntity::getId).collect(Collectors.toList());
            List<Long> notIdList = userForm.getRoleIdList().stream().filter(id -> !(idList.contains(id))).collect(Collectors.toList());
            return resultVOBuilder.failure("permission.roleSize.error", "当前角色部分{}信息不存在", notIdList);
        }
        userForm.setRoleEntity(roleEntityList.get(0));
        UserEntity buildUserEntity = UserEntity.build(userForm);
        UserEntity saveUserEntity = userRepository.save(buildUserEntity);
        return ResultVOBuilder.success(saveUserEntity);
    }

}
