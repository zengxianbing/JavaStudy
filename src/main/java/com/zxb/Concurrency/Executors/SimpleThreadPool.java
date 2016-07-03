package com.zxb.Concurrency.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/4/19.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class SimpleThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executorService.execute(worker);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        System.out.println("Finished all threads");
    }
}
