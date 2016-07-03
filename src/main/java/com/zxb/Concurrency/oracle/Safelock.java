package com.zxb.Concurrency.oracle;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Safelock {

	static class Friend{
		private final String name;
		
		public String getName() {
			return name;
		}

		private final Lock lock=new ReentrantLock();
		
		public Friend(String name){
			this.name=name;
		}
		
		public boolean impendingBow(Friend bower){
			Boolean myLock=false;
			Boolean yourLock=false;
			
			try {
				myLock=lock.tryLock();
				yourLock=bower.lock.tryLock();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(!(myLock&&yourLock)){
					if(myLock){
						lock.unlock();
					}
					if(yourLock){
						bower.lock.unlock();
					}
					
				}
			}
			return myLock&&yourLock;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
