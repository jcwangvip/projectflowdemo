package com.jc.javabase.java.lang.thread.series.createmode;

/**
 * 面试问题
 * 核心类
 * 同时继承了Thread 和 实现了Runnable 会怎么样?
 *
 * @author jiancheng
 * @date 2019-11-19
 */
public class Core_ThreadAndRunnableDemo extends Thread implements Runnable {

    @Override
    public void run() {
        super.run();
        System.out.println("这个run是怎么执行的?");
    }

    public static void main(String[] args) {
//        new Core_ThreadAndRunnableDemo().start();
//        Core_ThreadAndRunnableDemo core = new Core_ThreadAndRunnableDemo();
//        core.testStart();
    }

    private void testStart() {
        Child child = new Child();
//        Clazz child = new Child();
//        SuperClass child = new Child();
//        int i = child.testRun();
        String i = child.testSupper();
        System.out.println("输出testRun 的结果 : " + i);
        child.value();
    }

    interface Clazz {
        int testRun();
    }

    class SuperClass {

        String name;

        void value() {
            name = "China";
        }

        public SuperClass() {
            System.out.println("SuperClass 的默认构造方法执行");
        }

        public String testSupper() {
            return "supperClass";
        }

        int testRun() {
            System.out.println("父类的方法会被执行吗");
            return 99;
        }
    }

    class Child extends SuperClass implements Clazz {

        public Child() {
            System.out.println("Child 的默认构造方法执行");
        }

        @Override
        public String testSupper() {
            String s = super.testSupper();
            return s;
        }

        @Override
        public int testRun() {
            super.testRun();
            return 1;
        }

        String name;

        @Override
        void value() {
            name = "Shanghai";
            super.value();      //调用父类的方法
            System.out.println(name);
            System.out.println(super.name);
        }

    }

}
