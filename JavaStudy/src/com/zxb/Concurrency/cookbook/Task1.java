package com.zxb.Concurrency.cookbook;

import java.util.concurrent.ConcurrentSkipListMap;

public class Task1  implements Runnable{

	private ConcurrentSkipListMap<String, Contact> map;
	
	public Task1(ConcurrentSkipListMap<String, Contact> map, String id) {
		super();
		this.map = map;
		this.id = id;
	}

	private String id;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConcurrentSkipListMap<String, Contact> map;
		map=new ConcurrentSkipListMap<>();
		
		Thread threads[]=new Thread[25];
		int counter=0;

		
		for (char i='A'; i<'Z'; i++) {
		/*	Task task=new Task(map, String.valueOf(i));
			threads[counter]=new Thread(task);*/
			threads[counter].start();
			counter++;
			}
		
		
		for (int i=0; i<25; i++) {
			try {
			threads[i].join();
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
