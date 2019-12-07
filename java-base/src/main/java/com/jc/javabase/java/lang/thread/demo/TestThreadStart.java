package com.jc.javabase.java.lang.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程在什么时候开始
 *
 * @author jiancheng
 * @date 2019-11-26
 */
public class TestThreadStart {
    public static void main(String[] args) {
        System.out.println("当前main方法中的线程id = " + Thread.currentThread().getId());
//        demo();
        TestThreadStart t = new TestThreadStart();
//        t.demo1();
        t.demo2();

    }

    /**
     * 当前方法中开了线程池后每次new的对象就会有一个线程
     */
    private void demo2() {
        System.out.println("当前demo2方法中的线程id = " + Thread.currentThread().getId());
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            es.execute(new ThreadIdDemo());
        }
        es.shutdown();
    }

    /**
     * 和主线程是否new没关系,线程id还是都一样，都是主线程
     */
    private void demo1() {
        System.out.println("当前demo1方法中的线程id = " + Thread.currentThread().getId());
    }

    /**
     * 方法中直接调用线程id 都是一样的
     */
    private static void demo() {
        System.out.println("当前demo方法中的线程id = " + Thread.currentThread().getId());
    }


    class ThreadIdDemo implements Runnable {
        @Override
        public void run() {
            System.out.println("当前ThreadIdDemo类中的run方法中的线程id = " + Thread.currentThread().getId());
        }
    }
}
