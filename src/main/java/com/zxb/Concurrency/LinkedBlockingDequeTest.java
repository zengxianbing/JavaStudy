package com.zxb.Concurrency;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		BlockingDeque bDeque = new LinkedBlockingDeque(20);
		for (int i = 0; i < 30; i++) {
			bDeque.putFirst(i);

			System.out.println("向阻塞栈中添加了元素:" + i);
		}

		System.out.println("程序到此运行结束，即将退出----");
	}

}
