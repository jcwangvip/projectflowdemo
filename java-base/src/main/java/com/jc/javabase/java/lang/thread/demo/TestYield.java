package com.jc.javabase.java.lang.thread.demo;

/**
 * 测试睡眠
 *
 * @author jiancheng
 * @date 2019-11-22
 */
public class TestYield {

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        Object lock = new Object();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("INFO: A 等待锁");
                synchronized (lock) {
                    System.out.println("INFO: A 得到了锁 lock");
                    System.out.println("A 1");
                    System.out.println("INFO: A 准备进入阻塞状态，调用 Thread.yield 是否会放弃锁 lock 的控制权");
                    Thread.yield();
                    System.out.println("A貌似没有放弃锁,只是切换别的线程，遇到锁还是会回来执行完毕才释放锁的");
                    System.out.println("A 2");
                    System.out.println("A 3");
                }

            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("INFO: B 等待锁");
                synchronized (lock) {
                    System.out.println("INFO: B 得到了锁 lock");
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");

                    System.out.println("INFO: B 打印完毕，调用 lock.notify() 方法");
                    Thread.yield();
                    System.out.println("INFO: B这一定要有,要不A让出线程后有问题");
                }
            }
        });

        a.start();
        b.start();
    }


}
