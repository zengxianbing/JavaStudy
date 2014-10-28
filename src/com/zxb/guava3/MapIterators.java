package com.zxb.guava3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class MapIterators {

	@Test
    public void testMap(){
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(1,1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		
		for(Map.Entry<Integer, Integer> entry:map.entrySet()){
			System.out.println("key="+entry.getKey()+", Value="+entry.getValue());
		}
		
		for(Integer key:map.keySet()){
			System.out.println("key:"+key);
		}
		for(Integer value:map.values()){
			System.out.println("Value:"+value);
		}
		
		
		Iterator<Map.Entry<Integer,Integer>> entries=map.entrySet().iterator();
		
		while(entries.hasNext()){
			Map.Entry<Integer, Integer> entry=entries.next();
			System.out.println("key="+entry.getKey()+",Value="+entry.getValue());
		}
		
		
		
		
		Iterator entries1=map.entrySet().iterator();
		while(entries1.hasNext()){
			Map.Entry entry=(Map.Entry)entries1.next();
			
			Integer key=(Integer)entry.getKey();
			Integer value=(Integer)entry.getValue();
			
			System.out.println("key="+key+", Value="+value);
		}
		
		
		
	for(Integer key:map.keySet()){
		Integer value=map.get(key);
		System.out.println("key="+key+",Value"+value);
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
}
