package com.zxb.Concurrency.semaphore;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

/**
 * Created by cengxianbing on 2015/11/26.
 */
public class SemaphoreTest2 {
    private static final Logger LOG = LoggerFactory.getLogger(SemaphoreTest2.class);

    @Test
    public void testSemaphore1() {

        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < N; i++) {
            new Worker(i, semaphore).start();
        }


    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生成");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
