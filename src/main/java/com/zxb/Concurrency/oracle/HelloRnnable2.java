package com.zxb.Concurrency.oracle;

public class HelloRnnable2 extends Thread{

	String[] importtantInfo={"aa","bb","cc","dd"};
	public void run(){
//		System.out.println("Hello from a thread!");
		
		for(int i=0;i<importtantInfo.length;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			System.out.println(importtantInfo[i]);
		}
	}
	public static void main(String[] args) {
	   (new HelloRnnable2()).start();
	}
}
