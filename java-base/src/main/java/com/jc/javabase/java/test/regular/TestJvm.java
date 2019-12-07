package com.jc.javabase.java.test.regular;

/**
 * 测试jvm指令
 *
 * @author jiancheng
 * @date 2019-11-20
 */
public class TestJvm {
    public static void main(String[] args) throws InterruptedException {


        for (; ; ) {
            Thread.sleep(3000);
            System.out.println("持续输出" + Thread.currentThread().getId());
            System.out.println(265988928/1024/1024);
            System.out.println(4255822848L/1024/1024);
        }

    }
}
