package com.zxb.Concurrency.object;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2015/12/16.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class OutputThread implements Runnable {

    private int num;
    private Object lock;

    public OutputThread(int num, Object lock) {
        this.num = num;
        this.lock = lock;
    }

    @Override
    public void run() {

        try {
            while (true) {
                synchronized (lock) {
                    lock.notifyAll();
                    lock.wait();
                    System.out.println(num);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
