package com.jc.javabase.java.util.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-12-26
 */
public class ListDemo {
    public static void main(String[] args) {

        demo();
    }

    private static void demo() {
        List<String> list = new ArrayList<>();
        list.add("zhagsan");
        list.add("list");
        String next = list.iterator().next();
        System.out.println(next);
    }
}
