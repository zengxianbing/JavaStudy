package com.zxb.Concurrency.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/12.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class CyclicBarrierTest4 {

    private static int SIZE = 5;
    private static CyclicBarrier cb;

    public static void main(String[] args) {
        cb = new CyclicBarrier(SIZE);
        for (int i = 0; i < SIZE; i++) {
            new InnerThread().start();

        }
    }

    static class InnerThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " continued.");
        }
    }
}
