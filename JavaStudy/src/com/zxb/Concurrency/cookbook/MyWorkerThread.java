package com.zxb.Concurrency.cookbook;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class MyWorkerThread extends ForkJoinWorkerThread {

	private static ThreadLocal<Integer> taskCounter=new
			ThreadLocal<Integer>();
	protected MyWorkerThread(ForkJoinPool arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onStart() {
	super.onStart();
	System.out.printf("MyWorkerThread %d: Initializing taskcounter.\n",getId());
	taskCounter.set(0);
	}
	
	
	@Override
	protected void onTermination(Throwable exception) {
	System.out.printf("MyWorkerThread %d:%d\n",getId(),taskCounter.get());
	super.onTermination(exception);
	}
	
	
	public void addTask(){
		int counter=taskCounter.get().intValue();
		counter++;
		taskCounter.set(counter);
		}

	
}
