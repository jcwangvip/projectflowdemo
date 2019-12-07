package com.jc.javabase.java.lang.threadpool.demo;

import com.jc.javabase.util.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池创建
 *
 * @author jiancheng
 * @date 2019-11-22
 */
public class ExecuteServiceDemo {

    List<String> list = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        ExecuteServiceDemo o = new ExecuteServiceDemo();
        o.demo();
        /*while (true) {
            Thread.sleep(5000);
            System.out.println(o.list.size());
        }*/

    }

    private void demo() throws InterruptedException {
        System.out.println("开始创建线程池...");
        int i = 1;
        ThreadFactory threadFactory = null;
        ExecutorService es = new ThreadPoolExecutor(10, 30, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
        for (; ; ) {
            System.out.println("第 " + i + "次,执行execute");
            es.execute(new ThreadDemo());
            i++;
            if (i > 30) {
                Thread.sleep(5000);
                out(es);
            } else {
                out(es);
            }
        }
//        System.out.println("是否是最后执行");
//        es.shutdown();
    }

    private void out(ExecutorService es) throws InterruptedException {
        ThreadPoolExecutor tp = (ThreadPoolExecutor) es;
        int maximumPoolSize = tp.getMaximumPoolSize();
        int corePoolSize = tp.getCorePoolSize();
        int activeCount = tp.getActiveCount();
        int poolSize = tp.getPoolSize();
        long taskCount = tp.getTaskCount();
        System.out.print("当前线程池最大线程数 = " + maximumPoolSize + ",");
        System.out.print("当前线程池核心线程数 = " + corePoolSize + ",");
        System.out.print("当前线程池执行过的线程数 = " + activeCount + ",");
        System.out.print("当前线程池中当前线程数数 = " + poolSize + ",");
        System.out.print("当前线程池计划执行线程数 = " + taskCount + ",");
        System.out.println();
        Thread.sleep(500);
    }

    class ThreadDemo implements Runnable {

        @Override
        public void run() {
            /*for (; ; ) {
             *//*String uuid = UUID.randomUUID().toString();
                if (list.contains(uuid)) {
                    System.out.println("当前发生重复" + uuid + "当前线程名" + Thread.currentThread().getName());
                    break;
                } else {
                    list.add(uuid);
                }*//*
                Object o = new Object();
            }*/
            System.out.println("执行run方法" + DateUtils.getDate(new Date()));
        }
    }
}
