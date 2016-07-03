package com.zxb.Concurrency.CallableFuture;

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
public class CallableFutureTest1 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Task task = new Task();

        Future<Integer> result = executorService.submit(task);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程在执行任务完毕");

    }


}


