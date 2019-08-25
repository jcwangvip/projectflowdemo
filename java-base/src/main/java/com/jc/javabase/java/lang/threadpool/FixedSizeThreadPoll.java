package com.jc.javabase.java.lang.threadpool;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 线程池
 *
 * @author jiancheng
 * @date 2019-7-15
 */
public class FixedSizeThreadPoll {


    // 仓库
    private BlockingQueue<Runnable> blockingQueue;
    // 线程集合
    private List<Thread> workers;
    // 每一个线程要去干的事情---》从队列中拿任务
    public static class Worker extends Thread{

    }

}
