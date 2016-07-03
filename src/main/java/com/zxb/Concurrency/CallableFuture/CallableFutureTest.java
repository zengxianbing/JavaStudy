package com.zxb.Concurrency.CallableFuture;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by cengxianbing on 2015/11/26.
 */
public class CallableFutureTest {

    @Test
    public void testCallFuture1() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

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


    }

    @Test
    public void testCallFuture2() {

        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executor.submit(futureTask);
        executor.shutdown();

        /*Task task=new Task();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(task);
        Thread thread=new Thread(futureTask);
        thread.start();
        */

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程在执行任务");
        try {
            System.out.println("task运行结果" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕！");


    }

}

class Task implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
