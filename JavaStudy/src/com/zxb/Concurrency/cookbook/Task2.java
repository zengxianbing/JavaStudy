package com.zxb.Concurrency.cookbook;

import java.util.concurrent.TimeUnit;

public class Task2 implements Runnable {
	//18. 实现方法 run() 。在任务开始时打印一条信息，再让当前线程进入休眠2秒。最后在任务结束时，再打印另一条信息。
	@Override
	public void run() {
		System.out.printf("Task: Begin.\n");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Task: End.\n");
}
}
