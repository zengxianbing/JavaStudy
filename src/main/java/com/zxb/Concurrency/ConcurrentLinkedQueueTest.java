package com.zxb.Concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLinkedQueueTest {

	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

	private static int count = 2;

	private static CountDownLatch latch = new CountDownLatch(count);

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		long timeStart = System.currentTimeMillis();
		ExecutorService es = Executors.newFixedThreadPool(4);
		ConcurrentLinkedQueueTest.offer();
		for (int i = 0; i < count; i++) {
			es.submit(new Poll());

		}

		latch.await();
		System.out.println("cost time "
				+ (System.currentTimeMillis() - timeStart) + "ms");
		es.shutdown();

	}

	public static void offer() {
		for (int i = 0; i < 10000; i++) {
			queue.offer(i);
		}
	}

	static class Poll implements Runnable {

		@Override
		public void run() {

			while (!queue.isEmpty())
				System.out.println(queue.poll());
			latch.countDown();
		}

	}

}
