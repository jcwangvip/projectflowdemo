package com.example.springbootdemo.rest.restfuldemo.demo.permission.service;

import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.bean.RoleEntity;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.data.RoleFormData;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.form.RoleForm;
import com.example.springbootdemo.rest.restfuldemo.demo.permission.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Role测试类
 *
 * @author jiancheng
 * @date 2019-7-9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RoleServiceTest {

    @Autowired
    RoleService roleService;
    @Autowired
    RoleRepository roleRepository;

    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull(roleService);
    }

    @Test
    public void save() {
        RoleForm roleForm = RoleFormData.build(null, "root根", "增加root根");
        Long parentId = save(roleForm);
        RoleForm roleFormByRootNode = RoleFormData.build(parentId, "root一级节点1", "增加root一级节点1");
        save(roleFormByRootNode);

    }

    private Long save(RoleForm roleForm) {
        ResultVO<RoleEntity> resultVO = roleService.save(roleForm);
        if (!resultVO.isSuccess()) {
            Assert.assertTrue(false);
        }
        RoleEntity roleEntityResult = resultVO.getData();
        Long rootId = roleEntityResult.getId();
        RoleEntity getOneRoleEntity = roleRepository.getOne(rootId);
        Assert.assertNotNull(getOneRoleEntity);
        return rootId;
    }


}