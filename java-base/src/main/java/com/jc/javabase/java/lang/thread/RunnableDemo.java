package com.jc.javabase.java.lang.thread;

/**
 * 线程测试类
 *
 * @author jiancheng
 * @date 2019-7-16
 */
public class RunnableDemo {


    public static class TestRunnableDemo implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "在运行");
        }
    }

    public static void main(String[] args) {
        TestRunnableDemo t1 = new TestRunnableDemo();
        TestRunnableDemo t2 = new TestRunnableDemo();

        new Thread(t1).start();
        new Thread(t2).start();

        String a = "123";
        String b = "123";
        assert a == b;
        assert a.equals(b) == true;

    }


}
