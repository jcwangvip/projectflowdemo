package com.example.springbootdemo.common.vo;

import lombok.Data;

/**
 * Error
 *
 * @author jiancheng
 * @date 2019-5-13
 */
@Data
public class Error {

    private String code;
    private String message;
    private Object[] args;


}
