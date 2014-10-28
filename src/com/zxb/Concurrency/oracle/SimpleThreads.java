package com.zxb.Concurrency.oracle;

public class SimpleThreads {

	static void threadMessage(String message){
		String threadName=Thread.currentThread().getName();
		System.out.format("%s: %s%n",
				threadName,message);
	}
	
	private static class MessageLoop implements Runnable{

		@Override
		public void run() {

			String importantInfo[]={
					"aa",
					"bb",
					"cc",
					"dd"
			};
			
			for(int i=0;i<importantInfo.length;i++){
				try {
					Thread.sleep(4000);
					
					threadMessage(importantInfo[i]);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					threadMessage("I wan't done!");
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		public static void main(String args[]) throws InterruptedException{
			
			long patience=1000*60*60;
			
			if(args.length>0){
				try {
					patience=Long.parseLong(args[0])*1000;
				} catch (NumberFormatException e) {
                  System.out.println("Argument must be integer");
                  
                  System.exit(1);
				}
			}
			
			threadMessage("Starting MessageLoop thread");
			
			
			long startTime=System.currentTimeMillis();
			Thread t=new Thread(new MessageLoop());
			
			t.start();
			threadMessage("Waiting for MessageLoop thread to finsh");
			
			while(t.isAlive()){
				threadMessage("Still waiting....");
				t.join(1000);
				if(t.isAlive()&&(System.currentTimeMillis()-startTime)>patience){
					threadMessage("Tired of waiting!");
					t.interrupt();
					t.join();
				}
				
			}
			threadMessage("Finally!");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}


