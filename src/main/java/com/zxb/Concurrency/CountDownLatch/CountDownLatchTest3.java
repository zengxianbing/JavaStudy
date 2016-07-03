package com.zxb.Concurrency.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/12.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class CountDownLatchTest3 {
    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;

    public static void main(String[] args) {
        try {
            doneSignal = new CountDownLatch(LATCH_SIZE);
            for (int i = 0; i < LATCH_SIZE; i++) {

                new InnerThread().start();
            }
            System.out.println("main await begin.");
            doneSignal.await();
            System.out.println("main await finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class InnerThread extends Thread {
        public void run(){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" sleep 1000ms.");
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
