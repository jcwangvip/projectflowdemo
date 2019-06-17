package com.example.springbootdemo.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 日志记录表
 *
 * @author jiancheng
 * @date 2019-5-14
 */
@Data
@Entity
public class SysActionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求路径
     */
    private String requestUri;
    /**
     * 请求参数
     */
    private String params;

    /**
     * 执行时长(毫秒)
     */
    private Long time;

    /**
     * 状态  0：成功   1：失败
     */
    private Integer status;

    /**
     * ip
     */
    private String ip;

    /**
     * 用户浏览器信息
     */
    private String userAgent;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 版本号
     */
    @Version
    private short version;

}
