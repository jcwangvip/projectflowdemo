package com.example.springbootdemo.permission.bean;


import com.example.springbootdemo.permission.form.RoleForm;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 角色
 *
 * @author jiancheng
 * @date 2019-7-3
 */
@Entity
@Table(name = "system_role")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Column(unique = true, nullable = false)
    private String name;
    private Long parentId;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<UserEntity> users;
    @CreationTimestamp
    private Date createTime;
    private String createName;
    private String memo;

    @Version
    private short version;

    public RoleEntity() {
    }

    public static RoleEntity build(RoleForm roleForm) {
        RoleEntity role = new RoleEntity();
        // role.setCode(roleForm.getCode());
        role.setCode(UUID.randomUUID().toString());
        role.setName(roleForm.getName());
        role.setParentId(roleForm.getParentId());
        role.setMemo(roleForm.getMemo());
        return role;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", users=" + users +
                ", createTime=" + createTime +
                ", createName='" + createName + '\'' +
                ", memo='" + memo + '\'' +
                ", version=" + version +
                '}';
    }
}
