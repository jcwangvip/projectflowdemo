package com.jc.javabase.java.lang.thread.series.createmode;

/**
 * 实现Runnable
 *
 * @author jiancheng
 * @date 2019-11-19
 */
public class ImplRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }

    public static void main(String[] args) {
        new Thread(new ImplRunnable()).start();
        new Thread(new ImplRunnable()).start();
        new Thread(new ImplRunnable()).start();
        new Thread(new ImplRunnable()).start();
    }


}
