package com.zxb.Concurrency.cnblogs1;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo1 {
	 // TODO: queue是LinkedList对象时，程序会出错。
    //private static Queue<String> queue = new LinkedList<String>();
    private static Queue<String> queue = new ArrayBlockingQueue<String>(20);
    public static void main(String[] args) {
    
        // 同时启动两个线程对queue进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String value;
        Iterator iter = queue.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
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
                int i = 0;
            while (i++ < 6) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName()+i;
                queue.add(val);
                // 通过“Iterator”遍历queue。
                printAll();
            }
        }
    }
}
