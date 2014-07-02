package com.zxb.Performance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
	Map<String,String> map=null;
	@Before
	public void before(){
	 map=new HashMap<String,String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
	}
	
	@Test
	public void test1(){
		for(Entry<String,String> entry:map.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		
		Iterator<Map.Entry<String,String>> iterator=map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String,String> entry=iterator.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		
		for(String key:map.keySet()){
			System.out.println(key+":"+map.get(key));
		}
		
		
		Set<Entry<String,String>> entrySet=map.entrySet();
		for(Entry<String,String> entry:entrySet){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
