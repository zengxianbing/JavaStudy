package com.suggest;

public class SafeStopThread1 extends Thread {

	
	public void run(){
		while(!isInterrupted()){
			//Do Something
		}
	}
}
