package com.example.springbootdemo.permission.form;

import com.example.springbootdemo.permission.bean.RoleEntity;
import lombok.Data;

import javax.persistence.Transient;
import java.util.List;

/**
 * 用户表单对象
 *
 * @author jiancheng
 * @date 2019-7-4
 */
@Data
public class UserForm {

    private String code;
    private String name;
    private List<Long> roleIdList;
    private String memo;

    @Transient
    private List<RoleEntity> roleEntityList;
}
