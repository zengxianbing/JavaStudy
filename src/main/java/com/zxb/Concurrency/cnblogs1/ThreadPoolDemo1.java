package com.zxb.Concurrency.cnblogs1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo1 {
	 public static void main(String[] args) {
	        // 创建一个可重用固定线程数的线程池
	        ExecutorService pool = Executors.newFixedThreadPool(2);
	        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
	        Thread ta = new MyThread1();
	        Thread tb = new MyThread1();
	        Thread tc = new MyThread1();
	        Thread td = new MyThread1();
	        Thread te = new MyThread1();
	        // 将线程放入池中进行执行
	        pool.execute(ta);
	        pool.execute(tb);
	        pool.execute(tc);
	        pool.execute(td);
	        pool.execute(te);
	        // 关闭线程池
	        pool.shutdown();
	    }
	}

	class MyThread1 extends Thread {

	    @Override
	    public void run() {
	        System.out.println(Thread.currentThread().getName()+ " is running.");
	    }
}
