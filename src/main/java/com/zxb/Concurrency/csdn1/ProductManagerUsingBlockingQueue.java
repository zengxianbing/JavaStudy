package com.zxb.Concurrency.csdn1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProductManagerUsingBlockingQueue {

	static BlockingQueue<Integer> sharedQueue;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sharedQueue = new LinkedBlockingQueue<Integer>();

	        for (int i = 0; i < 10; i++){
	            Thread consumerThread = new Thread(new ConsumerWithBlockingQueue(sharedQueue));
	            consumerThread.start();
	        }

	        for (int i = 0; i < 10; i++){
	            Thread producerThread = new Thread(new ProducerWithBlockingQueue(i, sharedQueue));
	            producerThread.start();
	        }
	}

}

class ProducerWithBlockingQueue implements Runnable {

	private int amount;
	private final BlockingQueue<Integer> sharedQueue;

	public ProducerWithBlockingQueue(int amount,
			BlockingQueue<Integer> sharedQueue) {
		super();
		this.amount = amount;
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			sharedQueue.put(amount);
			System.out.println("produced: " + amount);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}











class ConsumerWithBlockingQueue implements Runnable{

	private final BlockingQueue<Integer> sharedQueue;
	
	public ConsumerWithBlockingQueue(BlockingQueue<Integer> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
	      try {
			System.out.println("consumed: " + sharedQueue.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}




















