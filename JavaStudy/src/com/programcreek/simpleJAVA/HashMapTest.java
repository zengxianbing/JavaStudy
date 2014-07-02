package com.programcreek.simpleJAVA;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Apple a1=new Apple("green");
		Apple a2=new Apple("red");
		
		HashMap<Apple,Integer> m=new HashMap<Apple,Integer>();
		m.put(a1, 10);
		m.put(a2, 20);
		
		System.out.println(m.get(new Apple("green")));
		
		
		
		
		
		
		
		HashMap<String,Integer> countMap=
		new HashMap<String,Integer>();
		
		/*if(countMap.keySet().contains(a)){
			countMap.put(a, countMap.get(a)+1);
		}else{
			countMap.put(a, 1);
		}
		*/
		
		
		Iterator it=countMap.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry pairs=(Map.Entry)it.next();
			System.out.println(pairs.getKey()+"="+pairs.getValue());
		}
		
		
		for(Map.Entry<String, Integer> entry:countMap.entrySet()){
			System.out.println(entry.getKey()+"_"+entry.getValue());
		}
		
		
		
		HashMap<String,Integer> countMap2=new 
		HashMap<String,Integer>();
		countMap2.put("a", 10);
		countMap2.put("b", 20);
		
		ValueComparator vc=new ValueComparator(countMap);
		TreeMap<String,Integer> sortedMap=
		new TreeMap<String,Integer>(vc);
		sortedMap.putAll(countMap2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
}

class ValueComparator implements Comparator<String>{
	Map<String,Integer> base;
	
	public ValueComparator(Map<String,Integer> base){
		this.base=base;
	}

	@Override
	public int compare(String a, String b) {
         
		if(base.get(a)>=base.get(b)){
			return -1;
		}else{
			return -1;
		}
	}
	
	
}

class Apple{
	private String color;

	public Apple(String color) {
		super();
		this.color = color;
	}
	
	public boolean equals(Object obj){
       if(!(obj instanceof Apple))
    	   return false;
       if(obj==this)
    	   return true;
       return this.color.equals(((Apple)obj).color);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
