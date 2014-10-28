package com.zxb.guava;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class logMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<Integer,String> logfileMap=Maps.newHashMap();
		logfileMap.put(1,"a.log" );
		logfileMap.put(2,"b.log");
		logfileMap.put(3, "c.log");
		System.out.println("logfileMap:"+logfileMap);
		
		Map<String,Integer> logfileInverseMap=Maps.newHashMap();
		logfileInverseMap=getInverseMap(logfileMap);
		System.out.println("logfileInverseMap:"+logfileInverseMap);
		
	}
    public static <S,T> Map<T,S> getInverseMap(Map<S,T> map){
    	Map<T,S> inverseMap=new HashMap<T,S>();
    	for(Entry<S,T> entry:map.entrySet()){
    		inverseMap.put(entry.getValue(), entry.getKey());
    		
    	}
    	return inverseMap;
    }

	
}
