package com.jc.logservice.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "interface_log")
public class InterfaceLogEntity implements LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String executeNo;
    private String dateSource;
    private String uniquelyNo;
    @Lob
    private String request;
    @Lob
    private String response;
    @CreationTimestamp
    private Date createTime;
    private String createName;
    @Version
    private Long version;


}
