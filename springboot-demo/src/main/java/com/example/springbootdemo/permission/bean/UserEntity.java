package com.example.springbootdemo.permission.bean;

import com.example.springbootdemo.permission.form.UserForm;
import com.example.springbootdemo.permission.form.UserUpdateForm;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @author jiancheng
 * @date 2019-7-3
 */
@Entity(name = "system_user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String phone;
    private String mailBox;
    @ManyToMany(fetch = FetchType.EAGER)
    @NotFound(action= NotFoundAction.IGNORE)
    private List<RoleEntity> roles;
    @CreationTimestamp
    private Date createTime;
    private String createName;
    private String memo;

    @Version
    private short version;


    public static UserEntity build(UserForm userForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setCode(userForm.getCode());
        userEntity.setName(userForm.getName());
        userEntity.setRoles(userForm.getRoleEntityList());
        userEntity.setCreateTime(new Date());
        userEntity.setMemo(userForm.getMemo());
        return userEntity;
    }

    public UserEntity build(UserUpdateForm userUpdateForm) {
        if (StringUtils.isNotBlank(userUpdateForm.getName())) {
            this.name = userUpdateForm.getName();
        }
        if (StringUtils.isNotBlank(userUpdateForm.getPhone())) {
            this.phone = userUpdateForm.getPhone();
        }
        if (StringUtils.isNotBlank(userUpdateForm.getMailBox())) {
            this.mailBox = userUpdateForm.getMailBox();
        }
        if (StringUtils.isNotBlank(userUpdateForm.getName())) {
            this.name = userUpdateForm.getName();
        }
        if (null != userUpdateForm.getRoleEntity()) {
            if (!roles.contains(userUpdateForm.getRoleEntity())) {
                roles.add(userUpdateForm.getRoleEntity());
            }
        }
        if (StringUtils.isNotBlank(userUpdateForm.getMemo())) {
            this.memo = userUpdateForm.getMemo();
        }
        return this;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mailBox='" + mailBox + '\'' +
                ", roles=" + roles +
                ", createTime=" + createTime +
                ", createName='" + createName + '\'' +
                ", memo='" + memo + '\'' +
                ", version=" + version +
                '}';
    }
}
