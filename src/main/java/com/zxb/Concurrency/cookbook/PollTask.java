package com.zxb.Concurrency.cookbook;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PollTask  implements Runnable{

	private ConcurrentLinkedDeque<String> list;

	public PollTask(ConcurrentLinkedDeque<String> list) {
		super();
		this.list = list;
	}
	
	public void run(){
		for(int i=0;i<5000;i++){
			list.pollFirst();
			list.pollLast();
		}
	}
	
	public static void main(String[] args) {
		
		
		ConcurrentLinkedDeque<String> list=new ConcurrentLinkedDeque<String>();
		Thread[] threads=new Thread[100];
		for(int i=0;i<threads.length;i++){
		     AddTask task=new AddTask(list);
			threads[i]=new Thread(task);
			threads[i].start();
			
			System.out.println("Main.class:"+threads[i].getName()+"  length:"+threads.length);
		}
		
		for(int i=0;i<threads.length;i++){
			PollTask task=new PollTask(list);
			threads[i]=new Thread(task);
			threads[i].start();
			
			System.out.println("Main.class:"+threads[i].getName()+"  length:"+threads.length);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
