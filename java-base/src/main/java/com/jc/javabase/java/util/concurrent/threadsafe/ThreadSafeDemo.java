package com.jc.javabase.java.util.concurrent.threadsafe;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程安全小案例
 * <p>
 * 线程安全是指共享资源在多线程环境下是安全的,不会因为被多个线程并发的修改而出现
 * 数据破环、修饰更新、死锁等问题
 * <p>
 * 被多个线程并发访问的全局变量、静态变量、文件、设备、Socket（套件字）等都属于共享资源，
 * 这些共享资源在多线程访问的情况下都要考虑线程安全问题
 * <p>
 * 线程安全主要考虑的3个方面
 * 1、可见性：当多个线程并发地读写某个共享资源时，每个线程总是能读取到改共享资源的最新数据
 * 2、原子性：某个线程对一个或多个共享资源所做的一连串写操作不会被中断，在此期间不会有其他线程对这些共享资源执行写操作
 * 3、有序性：单个线程内的操作必须是有序的
 *
 * @author jiancheng
 * @date 2019-9-14
 */
public class ThreadSafeDemo implements Runnable {

    public static final Set<Integer> data = new HashSet<>();
    public static int count;
    protected int page;

    public ThreadSafeDemo(int page) {
        this.page = page;
    }


    @Override
    public void run() {
        int v = page * 10000;
        for (int i = 0; i < 10000; i++) {
            data.add(v++);
            count++;
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            es.execute(new ThreadSafeDemo(i));
        }
        es.shutdown();
        try {
            es.awaitTermination(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        理论上这里应该打印的是200000,实际上不是,说明就是有线程安全问题
        System.out.println("data size = " + data.size());
        System.out.println(data.size());
        System.out.println("count = ");
        System.out.println("count = " + count);
    }
}
