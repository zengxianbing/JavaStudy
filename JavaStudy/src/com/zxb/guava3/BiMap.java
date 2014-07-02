package com.zxb.guava3;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

public class BiMap {
 
	@Test
	public void logMapTest(){
		Map<Integer,String> logfileMap=Maps.newHashMap();
		logfileMap.put(1, "a.log");
		logfileMap.put(2, "b.log");
		logfileMap.put(3, "c.log");
		logfileMap.put(4, "d.log");
		logfileMap.put(5, "e.log");
		logfileMap.put(6, "f.log");
		System.out.println("logfileMap:"+logfileMap);
	}
	
	public static <S,T> Map<T,S> getInverseMap(Map<S,T> map){
		Map<T,S> inverseMap=new HashMap<T,S>();
		for(Entry<S,T> entry:map.entrySet()){
			inverseMap.put(entry.getValue(), entry.getKey());
		}
		return inverseMap;
	}
	
	@Test
	public void logMapTest1(){
		Map<Integer,String> logfileMap=Maps.newHashMap();
		logfileMap.put(1, "a.log");
		logfileMap.put(2, "b.log");
		logfileMap.put(3, "c.log");
		logfileMap.put(4, "d.log");
		logfileMap.put(5, "e.log");
		System.out.println("logfileMap:"+logfileMap);
		Map<String,Integer> logfileInverseMap=Maps.newHashMap();
		logfileInverseMap=getInverseMap(logfileMap);
		System.out.println("logfileiInverseMap:"+logfileInverseMap);
		
		
	} 
	@Test
	public void BimapTest(){
		HashBiMap<Integer, String> logfileMap=HashBiMap.create();
		logfileMap.put(1, "a.log");
		logfileMap.put(2, "b.log");
		logfileMap.put(3, "c.log");
		logfileMap.put(4, "d.log");
		logfileMap.forcePut(4, "e.log");
		System.out.println("logfileMap:"+logfileMap);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
