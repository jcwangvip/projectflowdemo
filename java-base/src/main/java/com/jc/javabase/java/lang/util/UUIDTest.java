package com.jc.javabase.java.lang.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 测试uuid是否可以重复
 *
 * @author jiancheng
 * @date 2019-11-22
 */
public class UUIDTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (; ; ) {
            String uuid = UUID.randomUUID().toString();
            if (list.contains(uuid)) {
                System.out.println("当前uuid重复了 : " + uuid);
                break;
            } else {
                list.add(uuid);
                System.out.println(list.size());
            }
        }

    }
}
