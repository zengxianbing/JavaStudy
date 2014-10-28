package com.suggest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Worker implements Runnable{

	private CyclicBarrier cb;
	
	public Worker(CyclicBarrier cb) {
		super();
		this.cb = cb;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println(Thread.currentThread().getName()+"到达汇合点");
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}





















public class CyclicBarrierTest {

	public static void main(String[] args) {

		CyclicBarrier cb=new CyclicBarrier(2,new Runnable(){

			@Override
			public void run() {

				System.out.println("隧道已经打通");
			}
			
		});
		
		new Thread(new Worker(cb),"工人1").start();
		new Thread(new Worker(cb),"工人2").start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
