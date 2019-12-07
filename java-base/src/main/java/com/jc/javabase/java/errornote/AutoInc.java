package com.jc.javabase.java.errornote;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-14
 */
public class AutoInc {

    public static void main(String[] args) {
        int i = 1;
        prt("i : " + i);
        prt("++i : " + ++i); // Pre-increment
        prt("i++ : " + i++); // Post-increment
        prt("i : " + i);
        prt("--i : " + --i); // Pre-decrement
        prt("i-- : " + i--); // Post-decrement
        prt("i : " + i);
    }

    static void prt(String s) {
        System.out.println(s);
    }
}
