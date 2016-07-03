package com.zxb.Concurrency.Queue;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/12.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class ArrayBlockingQueueDemo1 {

    private static Queue<String> queue=new ArrayBlockingQueue<String>(20);

    public static void main(String[] args) {
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String value;
        Iterator iter = queue.iterator();
        while (iter.hasNext()) {
            value = (String) iter.next();
            System.out.print(value+", ");
        }
        System.out.println();
    }
    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i=0;
            while (i++ < 6) {
                String val=Thread.currentThread().getName()+i;
                queue.add(val);
                printAll();
            }
        }
    }
}
