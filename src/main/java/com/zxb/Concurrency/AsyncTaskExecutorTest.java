package com.zxb.Concurrency;

import org.junit.Test;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/6.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class AsyncTaskExecutorTest {

    @Test
    public void test() throws InterruptedException {

        AsyncTaskExecutor executor = new SimpleAsyncTaskExecutor("sys.out");
        executor.execute(new OutThread(), 5000L);
        System.out.println("Hello World!");
        Thread.sleep(10000);
    }

    static class OutThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {

                System.out.println(i + "start....");
                try {
                    Thread.sleep(2 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
