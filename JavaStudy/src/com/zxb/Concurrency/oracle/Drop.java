package com.zxb.Concurrency.oracle;

public class Drop {

	private String message;
	
	private boolean empty=true;
	
	public synchronized String take(){
		while(empty){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		empty=true;
		notifyAll();
		return message;
	}
	
	
	
	
	
	
	
	
	public synchronized void put(String message){
		while(!empty){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		empty=false;
		this.message=message;
		notifyAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
