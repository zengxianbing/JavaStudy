package com.zxb.Concurrency.cnblogs1;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest1 {

	/**
	 * @param args
	 */
	private static int LATCH_SIZE = 5;
	private static CountDownLatch doneSignal;

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		try {
			doneSignal = new CountDownLatch(LATCH_SIZE);
			for (int i = 0; i < LATCH_SIZE; i++) {
				new InnerThread().start();
			}
			System.out.println("main await begin.");
			// "主线程"等待线程池中5个任务的完成
			doneSignal.await();

			System.out.println("main await finished.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static class InnerThread extends Thread {
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()
						+ " sleep 1000ms.");
				// 将CountDownLatch的数值减1
				doneSignal.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
