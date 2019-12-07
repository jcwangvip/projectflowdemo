package com.jc.javabase.java.lang.thread.series.createmode;

/**
 * 匿名内部类的方式创建线程
 *
 * @author jiancheng
 * @date 2019-11-19
 */
public class InnerClass {

    public static void main(String[] args) {


        // Thread匿名类，重写Thread的run()方法
        new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " is running");
            }
        }.start();
        // Runnable匿名类，实现其run()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }).start();

        // 同上，使用lambda表达式函数式编程
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " is running")).start();


        InnerClass innerClass = new InnerClass();
        innerClass.request();
    }

    private void request() {
        new InnerClassExtendsThreadImpl().start();
    }

    public class InnerClassExtendsThreadImpl extends Thread implements Runnable {
        @Override
        public void run() {
            System.out.println(getName() + " is running - inner");
        }
    }

}
