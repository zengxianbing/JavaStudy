package com.zxb.Concurrency.cnblogs1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Depot {

	private int capacity;
	private int size;
	private Lock lock;
	private Condition fullCondition;
	private Condition emptyCondition;

	public Depot(int capacity) {
		super();
		this.capacity = capacity;
		this.size = 0;
		this.lock = new ReentrantLock();
		this.fullCondition = lock.newCondition();
		this.emptyCondition = lock.newCondition();
	}

	public void produce(int val) {
		lock.lock();
		try {
			// left 表示“想要生产的数量”(有可能生产量太多，需多此生产)
			int left = val;
			while (left > 0) {
				// 库存已满时，等待“消费者”消费产品。
				while (size >= capacity) {
					fullCondition.await();
				}
				// 获取“实际生产的数量”(即库存中新增的数量)
				// 如果“库存”+“想要生产的数量”>“总的容量”，则“实际增量”=“总的容量”-“当前容量”。(此时填满仓库)
				// 否则“实际增量”=“想要生产的数量”
				int inc = (size + left) > capacity ? (capacity - size) : left;
				size += inc;
				left -= inc;
				System.out.printf(
						"%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
						Thread.currentThread().getName(), val, left, inc, size);
				// 通知“消费者”可以消费了。

				emptyCondition.signal();
			}
		} catch (InterruptedException e) {
		} finally {

		}
	}

	public void consume(int val) {
		lock.lock();
		try {
			// left 表示“客户要消费数量”(有可能消费量太大，库存不够，需多此消费)
			int left = val;
			while (left > 0) {
				// 库存为0时，等待“生产者”生产产品。
				while (size <= 0)
					emptyCondition.await();
				// 获取“实际消费的数量”(即库存中实际减少的数量)
				// 如果“库存”<“客户要消费的数量”，则“实际消费量”=“库存”；
				// 否则，“实际消费量”=“客户要消费的数量”。

				int dec = (size < left) ? size : left;
				size -= dec;
				left -= dec;

				System.out.printf(
						"%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
						Thread.currentThread().getName(), val, left, dec, size);
				fullCondition.signal();

			}
		} catch (InterruptedException e) {
		} finally {
			lock.unlock();
		}
	}

}

class Producer {
	private Depot depot;

	public Producer(Depot depot) {
		super();
		this.depot = depot;
	}

	public void produce(final int val) {
		new Thread() {
			public void run() {
				depot.produce(val);
			}
		}.start();
	}
}

class Customer {
	private Depot depot;

	public Customer(Depot depot) {
		super();
		this.depot = depot;
	}

	public void consume(final int val) {
		new Thread() {

			public void run() {
				depot.consume(val);
			}
		}.start();

	}
}

public class LockTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  Depot mDepot = new Depot(100);
		           Producer mPro = new Producer(mDepot);
		           Customer mCus = new Customer(mDepot);
		   
		           mPro.produce(60);
		           mPro.produce(120);
		           mCus.consume(90);
		           mCus.consume(150);
		           mPro.produce(110);
	}

}
