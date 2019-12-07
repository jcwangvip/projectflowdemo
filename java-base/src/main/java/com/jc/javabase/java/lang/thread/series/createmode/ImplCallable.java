package com.jc.javabase.java.lang.thread.series.createmode;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口创建线程
 * 实现Callable接口，可以获取线程执行的结果，FutureTask实际上实现了Runnable接口
 *
 * @author jiancheng
 * @date 2019-11-19
 */
public class ImplCallable implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " is running");
        return Thread.currentThread().getId();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new ImplCallable());
        new Thread(task).start();
        System.out.println("等待完成任务");
        Long result = (Long) task.get();
        System.out.println("执行返回结果 : " + result);
    }
}
