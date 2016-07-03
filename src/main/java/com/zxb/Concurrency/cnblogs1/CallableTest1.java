package com.zxb.Concurrency.cnblogs1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

















class MyCallable implements Callable{
	public Integer call(){
		int sum=0;
		for (int i = 0; i < 100; i++) {
			sum+=i;
		}
		return Integer.valueOf(sum);
	}
}





















public class CallableTest1 {

	/**
	 * @param args
	 * @throws java.util.concurrent.ExecutionException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		
		
		
		ExecutorService pool=Executors.newSingleThreadExecutor();
		
		Callable c1=new MyCallable();
		Future f1=pool.submit(c1);
		System.out.println(f1.get());
		pool.shutdown();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
