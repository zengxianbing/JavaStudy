package com.programcreek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapStudy {

	private static final Map unmodifiableMap1;
	static{
		
		unmodifiableMap1=new HashMap();
		unmodifiableMap1.put(1, "one");
		unmodifiableMap1.put(2, "two");
		Map amap=Collections.unmodifiableMap(unmodifiableMap1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//0
		Map<Integer,Integer> map=new HashMap();
		map.put(1,1);
		map.put(3,5);
		map.put(5,6);
		map.put(4,89);
		
		List keyList=new ArrayList(map.keySet());
		List valueList=new ArrayList(map.values());
		List entryList=new ArrayList(map.entrySet());
		System.out.println(keyList);
		System.out.println(valueList);
		System.out.println(entryList);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		1
		for(Entry<Integer, Integer> entry:map.entrySet()){
			
           System.out.println(entry.getKey());
           System.out.println(entry.getValue());
		}
		
		
		
		
		
		
//		2
		
		Iterator itr=map.entrySet().iterator();
		while(itr.hasNext()){
			Entry entry=(Entry) itr.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		

//		3
		/*List list=new ArrayList(map.entrySet());
		Collections.sort(list,new Comparator(){

			 @Override
			  public int compare(Entry e1, Entry e2) {
			    return e1.getKey().compareTo(e2.getKey());
			  }
			
		});*/
		
		
		Map<Integer,Integer> mapTree=new TreeMap();
		mapTree.put(1, 3);
		mapTree.put(3, 5);
		mapTree.put(6, 8);
		
		
		/*SortedMap sortedMap=new TreeMap(new Comparator(){

			@Override
			public int compare(K e1, Object e2) {
				return e1.
			}
			
		});*/
		List list = new ArrayList(mapTree.entrySet());
		/*Collections.sort(list, new Comparator() {
		 
		

		@Override
		public int compare(Object e1, Object e2) {
			return (((Entry)e1).getValue()).equals((((Entry)e1).getValue()));
		}
		 
		});*/
		
		
		
		
		
		
	}

}
