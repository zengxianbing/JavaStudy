package com.zxb.Concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		BlockingQueue bqueue = new ArrayBlockingQueue(20);
		for (int i = 0; i < 30; i++) {
			bqueue.put(i);
			System.out.println("向阻塞队列中添加了元素:" + i);
		}

		System.out.println("程序到此运行结束，即将退出----");
	}

}
