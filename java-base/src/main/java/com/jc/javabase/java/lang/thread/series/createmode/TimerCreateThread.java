package com.jc.javabase.java.lang.thread.series.createmode;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器创建线程
 * <p>
 * 使用定时器java.util.Timer可以快速地实现定时任务，TimerTask实际上实现了Runnable接口
 *
 * @author jiancheng
 * @date 2019-11-19
 */
public class TimerCreateThread {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }, 0, 1000);

    }

}
