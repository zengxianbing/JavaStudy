package com.zxb.Concurrency.Executors;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/4/19.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class MyMonitorThread implements Runnable {

    private ThreadPoolExecutor executor;

    private int seconds;

    private boolean run = true;

    public MyMonitorThread(ThreadPoolExecutor executor, int seconds) {
        this.executor = executor;
        this.seconds = seconds;
    }

    public void shutdown() {
        this.run = false;
    }

    @Override
    public void run() {
        while (run) {
            System.out.println(String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
            this.executor.getPoolSize(),
            this.executor.getCorePoolSize(),
            this.executor.getActiveCount(),
            this.executor.getCompletedTaskCount(),
            this.executor.getTaskCount(),
            this.executor.isShutdown(),
            this.executor.isTerminated()));

            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
