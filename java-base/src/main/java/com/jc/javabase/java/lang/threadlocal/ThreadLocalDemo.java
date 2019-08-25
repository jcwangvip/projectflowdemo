package com.jc.javabase.java.lang.threadlocal;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * demo
 *
 * @author jiancheng
 * @date 2019-7-25
 */
public class ThreadLocalDemo implements Runnable {

    private final static ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        ExecutorService es = newFixedThreadPool(5);
        for (int i = 0; i < 20; i++){
            ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
            es.execute(threadLocalDemo);
        }
        es.shutdown();

    }

    @Override
    public void run() {
        System.out.println("start -> current = " + threadLocal.get());
        threadLocal.set(Thread.currentThread().getName());
        test();
    }

    private void test() {
        System.out.println("test -> current ThreadName = " + threadLocal.get());
    }

}
