package com.jc.javabase.java.util.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 计数器
 *
 * @author jiancheng
 * @date 2019-11-26
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {

        int count = 200;
        final CountDownLatch cl = new CountDownLatch(count);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < count; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("run方法中输出当前计数器中的值 = " + cl.getCount());
                    cl.countDown();
                }
            });
        }
        System.out.println("会每次走这吗?");
        try {
            cl.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("输出当前计数器中的值 = " + cl.getCount());

    }
}
