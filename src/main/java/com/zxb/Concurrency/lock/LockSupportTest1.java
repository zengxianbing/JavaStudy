package com.zxb.Concurrency.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/12.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class LockSupportTest1 {

    private static Thread mainThread;

    public static void main(String[] args) {
        ThreadA ta=new ThreadA("ta");
        mainThread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" start ta");
        ta.start();
        System.out.println(Thread.currentThread().getName()+" block");
        LockSupport.park(mainThread);
        System.out.println(Thread.currentThread().getName()+" continue");
    }
    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }
        public void run() {
            System.out.println(Thread.currentThread().getName()+" wakup others");
            LockSupport.unpark(mainThread);
        }
    }
}
