package com.zxb.Concurrency.cookbook;

import java.util.concurrent.ThreadLocalRandom;

public class TaskLocalRandom  implements Runnable{

	public TaskLocalRandom() {
		ThreadLocalRandom.current();
		}

	@Override
	public void run() {
	String name=Thread.currentThread().getName();
	for (int i=0; i<10; i++){
	System.out.printf("%s: %d\n",name,ThreadLocalRandom.
	current().nextInt(10));
	}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread threads[]=new Thread[3];
		
		for (int i=0; i<3; i++) {
			TaskLocalRandom task=new TaskLocalRandom();
			threads[i]=new Thread(task);
			threads[i].start();
			}

	}

}
