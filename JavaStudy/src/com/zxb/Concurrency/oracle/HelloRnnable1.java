package com.zxb.Concurrency.oracle;

public class HelloRnnable1 implements Runnable {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new Thread(new HelloRnnable1())).start();
	}

	@Override
	public void run() {

		System.out.println("Hello from  thread----1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello from  thread-----2");
	}
	}
		