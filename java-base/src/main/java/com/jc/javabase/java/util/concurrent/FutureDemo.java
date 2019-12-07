package com.jc.javabase.java.util.concurrent;

import java.util.concurrent.*;

/**
 * Future模式是常见的异步设计模式之一
 * <p>
 * 为什么用: future可以获取异步执行线程的返回值
 * 注意: 线程中发生异常,future就无法回去值了
 *
 * @author jiancheng
 * @date 2019-9-14
 */
public class FutureDemo {

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> ft = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("在call方法中睡上一段时间");
                Thread.sleep(10L);
                System.out.println("call 方法中sleep完毕");
                System.out.println("让程序出错" + 1 / 0);
                return "Hello Word";
            }
        });
        try {
            System.out.println("当前信息是位于ft获取之前一步");
            String result = ft.get();
            System.out.println("result 返回结果：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
