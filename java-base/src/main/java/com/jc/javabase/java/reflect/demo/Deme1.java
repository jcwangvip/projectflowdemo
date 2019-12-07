package com.jc.javabase.java.reflect.demo;

/**
 * 测试基本类型用equals对比
 *
 * @author jiancheng
 * @date 2019-10-21
 */
public class Deme1 {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 1;
        Integer integerA = 1;
        Integer integerB = 2;
        Integer integerC = 1;

        System.out.println("execute(a, b) = " + execute(a, b));
        System.out.println("execute(a, c) = " + execute(a, c));

        System.out.println("execute(integerA, integerB) = " + execute(integerA, integerB));
        System.out.println("execute(integerA, integerC) = " + execute(integerA, integerC));

    }

    private static boolean execute(Object a, Object b) {
        return a.equals(b);
    }

}
