package com.jc.javabase.java.lang.thread.demo;

/**
 * 测试thread
 * <p>
 * thread的调用一定要用start方法,千万不要直接调用run方法
 * 1、调用start方法是将线程变为就绪状态,什么时候运行时有操作系统决定的
 * 2、调用start方法后,就算线程内发生异常,不会影响线程调用方后续流程
 *
 * @author jiancheng
 * @date 2019-9-12
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(10L);
                // 这里发生异常,不会影响用start后面的执行
                int a = 1 / 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
         /*
         这里为什么不直接t.run();
         因为调用start后,run方法并不是马上执行,
         start方法只是将线程变为"就绪状态",什么时候运行时有操作系统决定的
         */
//         t.run();
        t.start();
        System.out.println("ok");
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("还ok吗?");
    }
}
