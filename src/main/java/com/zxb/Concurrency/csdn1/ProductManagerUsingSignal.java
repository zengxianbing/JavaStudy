package com.zxb.Concurrency.csdn1;

public class ProductManagerUsingSignal {

	static final int MAX_AMOUNT = 1000;
	int currentAmount;

	public ProductManagerUsingSignal() {

		currentAmount = 0;
		// TODO Auto-generated constructor stub
	}

	public synchronized void addProduct(int addAmount) {
		while (currentAmount + addAmount > MAX_AMOUNT) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		currentAmount += addAmount;
		System.out.println("produced: " + addAmount + " current: "
				+ currentAmount);
		notifyAll();
	}

	public synchronized void takeProduct(int takeAmount) {
		while (takeAmount > currentAmount) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		currentAmount -= takeAmount;
		System.out.println("consumed: " + takeAmount + " current: "
				+ currentAmount);
		notifyAll();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductManagerUsingSignal manager = new ProductManagerUsingSignal();

		for (int i = 0; i < 5; i++) {
			int consume = (int) Math.round(Math.random() * 50);
			Thread consumerThread = new Thread(new Consumer(consume, manager));
			consumerThread.start();
		}

		for (int i = 0; i < 10; i++) {
			int produce = (int) Math.round(Math.random() * 50);
			Thread producerThread = new Thread(new Producter(produce, manager));
			producerThread.start();
		}
	}

}

class Producter implements Runnable {

	private int amount;
	private ProductManagerUsingSignal manager;

	public Producter(int amount, ProductManagerUsingSignal manager) {
		super();
		this.amount = amount;
		this.manager = manager;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		manager.addProduct(amount);
	}

}

class Consumer implements Runnable {

	private int amount;
	private ProductManagerUsingSignal manager;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		manager.takeProduct(amount);
	}

	public Consumer(int amount, ProductManagerUsingSignal manager) {
		super();
		this.amount = amount;
		this.manager = manager;
	}

}
