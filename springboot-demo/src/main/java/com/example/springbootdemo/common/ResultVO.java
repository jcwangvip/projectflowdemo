package com.example.springbootdemo.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 统一返回封装vo对象
 *
 * @author jiancheng
 * @date 2019-5-13
 */
@Data
public class ResultVO<T> {

    private boolean success;
    private String errorCode;
    private String errorMessage;
    private Object[] errorArgs;
    private List<Error> errors;
    private T data;
    private Object hint;

    public void addError(Error error) {
        if (this.errors == null) {
            this.errors = new ArrayList();
        }
        this.errors.add(error);
        this.success = false;
    }

}
