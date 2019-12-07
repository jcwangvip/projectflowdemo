package com.jc.javabase.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors(执行者)
 * 为concurrent包中所定义的 Executor、ExecutorService、ScheduledExecutorService、ThreadFactory 和 Callable 类
 * 提供的的工厂和实用方法。此类支持以下各种方法：
 *
 * <p>
 * 创建并返回设置有常用配置字符串的 ExecutorService 的方法。
 * 创建并返回设置有常用配置字符串的 ScheduledExecutorService 的方法。
 * 创建并返回“包装的”ExecutorService 方法，它通过使特定于实现的方法不可访问来禁用重新配置。
 * 创建并返回 ThreadFactory 的方法，它可将新创建的线程设置为已知的状态。
 * 创建并返回非闭包形式的 Callable 的方法，这样可将其用于需要 Callable 的执行方法中。
 * </p>
 *
 * @author jiancheng
 * @date 2019-9-13
 */
public class ExecutorsDemo {

    public static void main(String[] args) {

        System.out.println("开始测试创建线程池...");
        System.out.println("通过Executors工具类创建");
        // 阿里手册不建议这么创建线程池
        ExecutorService es = Executors.newFixedThreadPool(20);
        System.out.println(es);

        es.shutdown();



        System.out.println("结束测试创建线程池");
    }

}
