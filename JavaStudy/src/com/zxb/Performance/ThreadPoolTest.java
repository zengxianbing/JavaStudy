package com.zxb.Performance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadPoolTest {

	@Test
	public void newCachedThreadPool() throws InterruptedException{
	
		ExecutorService cachedThreadPool=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			final int index=1;
			Thread.sleep(index*1000);
			cachedThreadPool.execute(new Runnable(){

				@Override
				public void run() {

					System.out.println(index);
				}
				
				
			});
			
		}
		
		 
	}
	
	@Test
	public void newFixedThreadPooltest(){
		ExecutorService fixedThreadPool=Executors.newFixedThreadPool(3);
		for(int i=0;i<10;i++){
			final int index=i;
			fixedThreadPool.execute(new Runnable(){

				@Override
				public void run() {

					System.out.println(index);
					try {
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
	public void  newScheduledThreadPoolTest(){
		
		ScheduledExecutorService scheduledThreadPool=
				Executors.newScheduledThreadPool(5);
		
		scheduledThreadPool.schedule(new Runnable(){
			public void run(){
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS
		);
		
		
		
		
		scheduledThreadPool.scheduleAtFixedRate(new Runnable(){
			public void run(){
				System.out.println("delay 1 seconds, and excute every 3 seconds");
			}
		}, 1,3,TimeUnit.SECONDS
		);
	}
	
	
	
	@Test
	public void newSingleThreadExecutorTest(){
		ExecutorService singleThreadExector=
				Executors.newSingleThreadExecutor();
		
		for(int i=0;i<10;i++){
			final int index=0;
		singleThreadExector.execute(new Runnable(){

			@Override
			public void run() {

				System.out.println(index);
			}
			
		});
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
