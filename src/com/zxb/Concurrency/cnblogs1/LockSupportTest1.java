package com.zxb.Concurrency.cnblogs1;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest1 {

	/**
	 * @param args
	 */

	private static Thread mainThread;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThreadA ta = new ThreadA("ta");
		mainThread = Thread.currentThread();
		System.out.println(Thread.currentThread().getName() + " start ta");
		ta.start();

		System.out.println(Thread.currentThread().getName() + " block");
		// 主线程阻塞
		LockSupport.park(mainThread);

		System.out.println(Thread.currentThread().getName() + " continue");
	}

	static class ThreadA extends Thread {
		public ThreadA(String name) {
			super(name);
		}

		public void run() {
			System.out.println(Thread.currentThread().getName()
					+ " wakup others");
			// 唤醒“主线程”
			LockSupport.unpark(mainThread);
		}
	}

}
