package com.zxb.Concurrency.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/4/19.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class CyclicBarrierTest1 {

    public static void main(String[] args) {

        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程："+ Thread.currentThread().getName());
            }
        });
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CyclicBarrier重用");

        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }

    }


    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;


        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据。。。。");
            try {
                Thread.sleep(50000);
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
