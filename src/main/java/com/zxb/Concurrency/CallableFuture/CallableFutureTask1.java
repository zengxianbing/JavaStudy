package com.zxb.Concurrency.CallableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/4/19.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class CallableFutureTask1 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Task task = new Task();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);


        executorService.submit(futureTask);
        executorService.shutdown();

       /* Task task = new Task();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);

        Thread thread = new Thread(futureTask);
        thread.start();
        */

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        try {
            System.out.println("task运行结果："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}


