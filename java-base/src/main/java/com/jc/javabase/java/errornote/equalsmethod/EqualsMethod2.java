package com.jc.javabase.java.errornote.equalsmethod;

/**
 * equals方法易错记录
 *
 * @author jiancheng
 * @date 2019-10-14
 */
public class EqualsMethod2 {
    public static void main(String[] args) {
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        // 这里value的对象有两个地址
        System.out.println(v1.equals(v2));
    }

    static class Value {
        int i;
    }
}
