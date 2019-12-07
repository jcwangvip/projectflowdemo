package com.jc.javabase.java.lang.thread.series.createmode;

/**
 * 创建方式一:继承Thread
 *
 * @author jiancheng
 * @date 2019-11-19
 */
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + " is running");
    }

    public static void main(String[] args) {

        new ExtendsThread().start();
        new ExtendsThread().start();
        new ExtendsThread().start();
        new ExtendsThread().start();
    }
}
