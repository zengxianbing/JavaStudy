package com.zxb.Concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/12.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class SemaphoreTest3 {

    private static final int SEM_MAX = 10;

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(SEM_MAX);
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new MyThread(sem, 5));
        threadPool.execute(new MyThread(sem, 4));
        threadPool.execute(new MyThread(sem, 7));
        threadPool.shutdown();
    }

    static class MyThread extends Thread {
        private volatile Semaphore sem;
        private int count;

        public MyThread(Semaphore sem, int count) {
            this.sem = sem;
            this.count = count;
        }

        public void run() {
            try {
                sem.acquire(count);
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " acquire count=" + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sem.release(count);
                System.out.println(Thread.currentThread().getName() + " release " + count + "");
            }
        }
    }
}
