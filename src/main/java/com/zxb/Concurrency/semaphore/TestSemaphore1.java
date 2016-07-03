package com.zxb.Concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/4/18.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class TestSemaphore1 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semp = new Semaphore(5);

        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semp.acquire();
                        System.out.println("Accessing:" + NO);
                        Thread.sleep((long) (Math.random() * 10000));

                        semp.release();
                        System.out.println("------------" + semp.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }

                }
            };


            exec.execute(run);


        }


        exec.shutdown();
    }
}
