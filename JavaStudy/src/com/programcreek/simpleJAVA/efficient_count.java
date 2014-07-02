package com.programcreek.simpleJAVA;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class MutableInteger{
	private int val;
	
	public MutableInteger(int val){
		this.val=val;
	}
	
	public int get(){
		return val;
	}
	
	public void set(int val){
		this.val=val;
	}
	
	public String toString(){
		return Integer.toString(val);
	}
}



public class efficient_count {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s="one two three two three three";
		String[] sArr=s.split(" ");
		HashMap<String,Integer> counter=new
				HashMap<String,Integer>();
		for(String a:sArr){
			if(counter.containsKey(a)){
				int oldValue=counter.get(a);
				counter.put(a, oldValue+1);
			}else{
				counter.put(a, 1);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		HashMap<String,MutableInteger> newCounter=new
	     HashMap<String,MutableInteger>();
		for(String a:sArr){
			if(newCounter.containsKey(a)){
				MutableInteger oldValue=newCounter.get(a);
				oldValue.set(oldValue.get()+1);
			}else{
				newCounter.put(a, new MutableInteger(1));
			}
		}
		
		
		
		
		HashMap<String,MutableInteger> efficientCount=new
				HashMap<String,MutableInteger>();
		for(String a:sArr){
			MutableInteger initValue=new MutableInteger(1);
			MutableInteger oldValue=efficientCount.put(a, initValue);
		
			if(oldValue!=null){
				initValue.set(oldValue.get()+1);
			}
		}
		
		
		HashMap<String,MutableInteger> efficientCounter2=new
				HashMap<String,MutableInteger>();
		for(int i=0;i<1000000;i++){
			for(String a:sArr){
				MutableInteger value=efficientCounter2.get(a);
				
				if(value!=null){
					value.set(value.get()+1);
				}else{
					efficientCounter2.put(a, new MutableInteger(1));
				}
					
			}
		}
		
		
		HashMap<String,AtomicInteger> atomicCounter=
				new HashMap<String,AtomicInteger>();
		for(int i=0;i<1000;i++){
			for(String a:sArr){
				AtomicInteger value=atomicCounter.get(a);
				
				if(value!=null){
					value.incrementAndGet();
				}else{
					atomicCounter.put(a, new AtomicInteger());
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
