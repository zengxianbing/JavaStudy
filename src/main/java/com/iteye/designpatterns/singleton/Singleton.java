package com.iteye.designpatterns.singleton;

public class Singleton {

	private static Singleton instance=null;
	
	private Singleton(){}
	
/*	public static Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}
*/
	/*	public static synchronized Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}*/
	
	public static Singleton getInstance(){
		if(instance==null){
			synchronized(instance){
				if(instance==null){
					instance=new Singleton();
				}
			}
		}
		return instance;
	}
	
	public Object readResolve(){
		return instance;
	}
}
