package com.zxb.Concurrency.Executors;

import java.util.concurrent.*;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/4/19.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class WorkerPool {
    public static void main(String[] args) {
        RejectedExecutionHandlerImpl rejectedExecutionHandler = new RejectedExecutionHandlerImpl();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,4,10, TimeUnit.SECONDS
        ,new ArrayBlockingQueue<Runnable>(2),threadFactory,rejectedExecutionHandler);

        MyMonitorThread myMonitorThread = new MyMonitorThread(threadPoolExecutor, 3);

        Thread monitorThread = new Thread(myMonitorThread);


        monitorThread.start();


        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new WorkerThread("cmd"+i));
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myMonitorThread.shutdown();


    }
}
