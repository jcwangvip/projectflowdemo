package com.example.springbootdemo.rest.requestmethod.resttemplate.vo;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-21
 */
public class RemoteResultVO {


    /**
     * code : 0
     * msg : 执行成功
     * data : 报价单状态已完成同步
     */

    private String code;
    private String msg;
    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
