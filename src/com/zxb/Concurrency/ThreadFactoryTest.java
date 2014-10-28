package com.zxb.Concurrency;

import java.util.concurrent.ThreadFactory;

class SimpleThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		return new Thread(r);
	}
	
}

class ThreadTest implements Runnable{

	@Override
	public void run() {

		System.out.println("=====asdf======");
	}
	
}

public class ThreadFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		SimpleThreadFactory f=new SimpleThreadFactory();
		f.newThread(new ThreadTest()).start();
	}

}
