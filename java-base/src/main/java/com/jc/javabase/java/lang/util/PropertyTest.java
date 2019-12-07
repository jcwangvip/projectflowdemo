package com.jc.javabase.java.lang.util;

import java.util.Date;
import java.util.Properties;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-14
 */
public class PropertyTest {
    public static void main(String[] args) {
        System.out.println(new Date());
        Properties p = System.getProperties();
        p.list(System.out);
        System.out.println("--- Memory Usage:");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total Memory = " + rt.totalMemory() + " Free Memory = " + rt.freeMemory());
    }
}
