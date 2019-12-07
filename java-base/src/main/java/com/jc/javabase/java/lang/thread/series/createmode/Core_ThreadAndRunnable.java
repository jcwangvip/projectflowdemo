package com.jc.javabase.java.lang.thread.series.createmode;

/**
 * 面试问题
 * 核心类
 * 同时继承了Thread 和 实现了Runnable 会怎么样?
 *
 * @author jiancheng
 * @date 2019-11-19
 */
public class Core_ThreadAndRunnable {
    public static void main(String[] args) {


        new Thread(() -> {
            System.out.println("Runnable: " + Thread.currentThread().getName() + " is running");
        }) {
            @Override
            public void run() {
                System.out.println("Thread: " + getName());
            }
        }.start();

    }
}
