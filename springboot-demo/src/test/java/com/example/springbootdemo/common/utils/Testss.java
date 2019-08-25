package com.example.springbootdemo.common.utils;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-8-6
 */
public class Testss {


    public static void main(String[] args) {
        dg(10);
    }

    public static void dg(int i) {
        if (i < 0) {
            System.out.println("结束");
        } else {
            System.out.println(i--);
            dg(i);
        }
    }

    class User {

        private int i;

    }


}
