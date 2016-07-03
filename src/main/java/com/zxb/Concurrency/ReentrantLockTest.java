package com.zxb.Concurrency;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cengxianbing on 2015/11/27.
 */
public class ReentrantLockTest  {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Lock lock = new ReentrantLock();




    public static void main(String[] args)  {
        final ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread() {
            @Override
            public void run() {
                reentrantLockTest.insert(Thread.currentThread());
            }

            ;
        }.start();

        new Thread() {
            @Override
            public void run() {
                reentrantLockTest.insert(Thread.currentThread());
            }

            ;
        }.start();

    }

    public void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁");
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();

        }

    }



}
