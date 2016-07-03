package com.zxb.Concurrency;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/12.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class WaitTest1 {

    public static void main(String[] args) {
        ThreadA ta = new ThreadA("ta");
        synchronized (ta) {
            try {
                System.out.println(Thread.currentThread().getName() + "start ta");
                ta.start();
                System.out.println(Thread.currentThread().getName() + "block");
                ta.wait();
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {

            super(name);
        }

        public void run() {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "wakup others");
                notify();
            }
        }
    }
}
