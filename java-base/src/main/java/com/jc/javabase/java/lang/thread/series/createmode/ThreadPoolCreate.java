package com.jc.javabase.java.lang.thread.series.createmode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池创建
 * <p>
 * 使用线程池的方式，可以复用线程，节约系统资源。
 *
 * @author jiancheng
 * @date 2019-11-19
 */
public class ThreadPoolCreate {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            es.execute(() -> System.out.println(Thread.currentThread().getName() + " is running"));
        }
        System.out.println("结束");

    }
}
