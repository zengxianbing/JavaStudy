package com.zxb.Concurrency.csdn1;

public class ProductManagerUsingSync {

	static final int MAX_AMOUNT = 1000;
	int currentAmount;

	public boolean addProduct(int addAmount) {
		if (currentAmount + addAmount > MAX_AMOUNT) {
			return false;
		}
		currentAmount += addAmount;
		System.out.println("produced: " + addAmount + " current: "
				+ currentAmount);
		return true;
	}

	public boolean takeProduct(int takeAmount) {
		if (takeAmount > currentAmount) {
			return false;
		}
		currentAmount -= takeAmount;
		System.out.println("consumed: " + takeAmount + " current: "
				+ currentAmount);
		return true;
	}

	public ProductManagerUsingSync() {

		currentAmount = 0;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ProductManagerUsingSync manager = new ProductManagerUsingSync(); 
	        
	        for (int i = 0; i < 5; i++){
	            int consume = (int) Math.round(Math.random()*50) + 10;
	            Thread consumerThread = new Thread(new ConsumerWithSync(consume, manager));
	            consumerThread.start();
	        }
	        
	        for (int i = 0; i < 10; i++){
	            int produce = (int) Math.round(Math.random()*50) + 10;
	            Thread producerThread = new Thread(new ProducerWithSync(produce, manager));
	            producerThread.start();
	        }
	}

}

class ProducerWithSync implements Runnable {

	private int amount;
	private ProductManagerUsingSync manager;

	public ProducerWithSync(int amount, ProductManagerUsingSync manager) {
		super();
		this.amount = amount;
		this.manager = manager;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			synchronized (manager) {
				if (manager.addProduct(amount))
					return;
			}
		}
	}

}

class ConsumerWithSync implements Runnable {

	private int amount;
	private ProductManagerUsingSync manager;

	public ConsumerWithSync(int amount, ProductManagerUsingSync manager) {
		super();
		this.amount = amount;
		this.manager = manager;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			synchronized (manager) {
				if (manager.takeProduct(amount))
					return;
			}
		}
	}

}
