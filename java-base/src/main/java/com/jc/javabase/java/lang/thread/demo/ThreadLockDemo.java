package com.jc.javabase.java.lang.thread.demo;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-9-15
 */
public class ThreadLockDemo {

    public static void main(String[] args) throws InterruptedException {

        while (1 == 1) {
            Thread.sleep(100L);
            System.out.println("我要一直执行.当前线程信息" + Thread.currentThread().getId());
//            Thread.dumpStack();
        }

    }
}
