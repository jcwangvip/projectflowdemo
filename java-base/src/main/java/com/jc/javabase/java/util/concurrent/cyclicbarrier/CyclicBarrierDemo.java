package com.jc.javabase.java.util.concurrent.cyclicbarrier;


import com.jc.javabase.util.DateUtils;

import java.util.Date;
import java.util.concurrent.*;

/**
 * 是一种可重用的线程阻塞器
 *
 * @author jiancheng
 * @date 2019-11-26
 */
public class CyclicBarrierDemo implements Runnable {

    private static final CyclicBarrier c = new CyclicBarrier(5);
    private int page;

    public CyclicBarrierDemo(int page) {
        this.page = page;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(1000L + page * 1000L);
                System.out.println("线程id = " + Thread.currentThread().getId() + "   " + c.getNumberWaiting() + " waiting threads");
                c.await(10L, TimeUnit.SECONDS);
                System.out.println("线程id = " + Thread.currentThread().getId() + "   " + "时间 = " + DateUtils.getDate(new Date()) + " continue...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        demo();
//        demo1();

    }

    private static void demo1() {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo(3);
        cyclicBarrierDemo.run();
    }

    private static void demo() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo(i);
            executorService.execute(cyclicBarrierDemo);
        }
        executorService.shutdown();
    }
}
