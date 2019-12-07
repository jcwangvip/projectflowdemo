package com.jc.javabase.java.util.concurrent.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 类描述
 *
 * @author jiancheng
 * @date 2019-10-24
 */
public class SynchronousQueueQuiz {
    public static void main(String[] args) throws Exception {

        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        System.out.print(queue.offer(1) + " ");
        System.out.print(queue.offer(2) + " ");
        System.out.print(queue.offer(3) + " ");
        System.out.print(queue.take() + " ");
        System.out.println(queue.size());

    }
}