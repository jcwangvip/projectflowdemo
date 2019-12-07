package com.jc.javabase.java.lang.thread.demo;

/**
 * 线程类
 *
 * @author jiancheng
 * @date 2019-11-25
 */
public class MyThreadRun extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("MyThreadRun - id = " + Thread.currentThread().getId() + " 名字 = " + Thread.currentThread().getName() + ",执行MyThreadRun 的run 方法 时候的线程状态 = " + Thread.currentThread().getState());
    }
}
