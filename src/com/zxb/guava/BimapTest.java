package com.zxb.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BimapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BiMap<Integer,String> logfileMap=HashBiMap.create();
		logfileMap.put(1, "a.log");
		logfileMap.put(2, "b.log");
		logfileMap.put(3, "c.log");
     	//logfileMap.put(4, "c.log");
		
		logfileMap.put(4, "d.log");
		logfileMap.forcePut(5, "d.log");
		System.out.println("logfileMap:"+logfileMap);
		BiMap<String,Integer> filelogMap=logfileMap.inverse();
		System.out.println("filelogMap:"+filelogMap);
		
		
		logfileMap.put(6, "g.log");
		System.out.println("logfileMap:"+logfileMap);
		
	    System.out.println("filelogMap:"+filelogMap);
		
		
	}

}
