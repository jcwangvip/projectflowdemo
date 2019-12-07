package com.jc.javabase.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-9-13
 */
public class Executors_newCachedThreadPool {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = Executors.newCachedThreadPool();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    // 无论用shutdown()还是用shutdownNow()去关闭线程池,此线程最终都会停止
                    while (!Thread.interrupted() && i < Integer.MAX_VALUE) {
                        i++;
                    }
                }
            });
        }
        es.shutdown();
//        es.shutdownNow();
        es.awaitTermination(10L, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis() - l);
    }
}
