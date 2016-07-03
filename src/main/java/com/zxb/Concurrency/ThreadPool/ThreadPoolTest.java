package com.zxb.Concurrency.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadPoolTest {

	@Test
	public void test1() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {

				@Override
				public void run() {

					System.out.println(index);

				}

			});
		}
	}
	
	
	
	
	
	
	
	
	@Test
	public void test2(){
		ExecutorService fixedThreadPool=Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index=i;
			fixedThreadPool.execute(new Runnable(){

				@Override
				public void run() {

					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			
		}
	}
	
	
	
	
	
	
	
	
	@Test
	public void test3(){
		ScheduledExecutorService scheduledThreadPool=Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable(){

			@Override
			public void run() {

				System.out.println("delay 3 seconds");
				
			}
			
		}, 3, TimeUnit.SECONDS);
		
		
		
		
		
		
	}
	
	
	@Test
	public void test4(){
		ExecutorService singleThreadExecutor=Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
		  final int index=i;
		  singleThreadExecutor.execute(new Runnable(){

			@Override
			public void run() {

				try {
					System.out.println(index);
					Thread.sleep(2000);
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			  
		  });
			
		}
	}
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
