package com.jc.javabase.java.lang.thread.demo;

/**
 * 测试线程api方法
 *
 * @author jiancheng
 * @date 2019-11-25
 */
public class TestThreadApiDemo {
    public static void main(String[] args) {
        System.out.println("main - 当前线程 id = " + Thread.currentThread().getId() + " 名字 = " + Thread.currentThread().getName() + ",状态 = " + Thread.currentThread().getState());
        demo();
        System.out.println("main - 当前线程id = " + Thread.currentThread().getId() + " 名字 = " + Thread.currentThread().getName() + ",状态 = " + Thread.currentThread().getState());
    }

    private static void demo() {
        System.out.println("A - 开始测试线程API...");
        MyThreadRun t = new MyThreadRun();
        t.setName("自定义的线程名字-jcWang");
        System.out.println("A - 创建完线程,主线程id = " + Thread.currentThread().getId() + " 名字 = " + Thread.currentThread().getName() + ",的状态 = " + Thread.currentThread().getState());
        System.out.println("创建的线程id = " + t.getId() + " 名字 = " + t.getName() + ",的状态 = " + t.getState());
        t.start();
        System.out.println("A - 调用完start, 主线程id = " + Thread.currentThread().getId() + " 名字 = " + Thread.currentThread().getName() + ",的状态 = " + t.getState());
        System.out.println("调用完start,创建的线程 = " + t.getId() + " 名字 = " + t.getName() + ",的状态 = " + t.getState());
        if (t.isInterrupted()){
            System.out.println("调用完isInterrupted = true,创建的线程 = " + t.getId() + " 名字 = " + t.getName() + ",的状态 = " + t.getState());
        }else {
            System.out.println("调用完isInterrupted = false,创建的线程 = " + t.getId() + " 名字 = " + t.getName() + ",的状态 = " + t.getState());
        }
        t.interrupt();
        System.out.println("调用完interrupt,创建的线程 = " + t.getId() + " 名字 = " + t.getName() + ",的状态 = " + t.getState());
        while (t.isInterrupted()){
            System.out.println("调用完interrupt while 中,创建的线程 = " + t.getId() + " 名字 = " + t.getName() + ",的状态 = " + t.getState());
        }
        System.out.println("调用完interrupt while 后,创建的线程 = " + t.getId() + " 名字 = " + t.getName() + ",的状态 = " + t.getState());

    }
}
