package com.zxb.Concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/6/2.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class AbortPolicyDemo {

    private static final int THREADS_SIZE = 1;
    private static final int CAPACITY = 1;

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(THREADS_SIZE, THREADS_SIZE, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(CAPACITY));

        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {

            Runnable discardPolicyRunnable = new DiscardPolicyRunnable("task-" + i);
            pool.execute(discardPolicyRunnable);
        }


        pool.shutdown();
    }
}
