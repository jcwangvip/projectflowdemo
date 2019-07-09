package com.example.springbootdemo.permission.service.impl;

import com.example.springbootdemo.common.ResultVO;
import com.example.springbootdemo.common.ResultVOBuilder;
import com.example.springbootdemo.permission.bean.RoleEntity;
import com.example.springbootdemo.permission.form.RoleForm;
import com.example.springbootdemo.permission.repository.RoleRepository;
import com.example.springbootdemo.permission.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * 角色服务实现类
 *
 * @author jiancheng
 * @date 2019-7-3
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ResultVOBuilder resultVOBuilder;


    /**
     * 保存
     *
     * @param roleForm 前端值对象
     * @return resultVO
     */
    @Transactional(rollbackOn = Exception.class)
    @Override
    public ResultVO<RoleEntity> save(RoleForm roleForm) {
        if (roleForm.getParentId() == null) {
            long count = roleRepository.count();
            if (count > 0) {
                return resultVOBuilder.failure("请给定父节点");
            }
        } else {
            Optional<RoleEntity> optional = roleRepository.findById(roleForm.getParentId());
            if (!optional.isPresent()) {
                return resultVOBuilder.failure("当前父节点不存在");
            }
        }
        RoleEntity saveRole = roleRepository.save(RoleEntity.build(roleForm));
        return ResultVOBuilder.success(saveRole);
    }
}
