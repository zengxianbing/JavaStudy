package com.zxb.Concurrency.ForkJoin;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

import org.junit.Test;

public class Calculator extends RecursiveTask<Integer> {

	private static final int THRESHOLD=100;
	private int start;
	private int end;
	
	
	public Calculator(int start, int end) {
		//super();
		this.start = start;
		this.end = end;
	}


	@Override
	protected Integer compute() {

		int sum=0;
		if((end-start)<THRESHOLD){
			for(int i=start;i<end;i++){
				sum+=i;
			}
		}else{
			int middle=(start+end)/2;
			Calculator left=new Calculator(start,middle);
			Calculator right=new Calculator(middle+1,end);
			left.fork();
			right.fork();
			
			sum=left.join()+right.join();
		}
		return sum;
	}

	@Test
	public void test1() throws InterruptedException, ExecutionException{
		ForkJoinPool forkJoinPool=new ForkJoinPool();
		Future<Integer> result=forkJoinPool.submit(
				new Calculator(1,10000));
		
		assertEquals(new Integer(49995000), result.get());
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
