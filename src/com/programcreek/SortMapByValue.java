package com.programcreek;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortMapByValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		HashMap<String,Integer> map=new HashMap<String,Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println(map);
		
		TreeMap<String,Integer> sortedMap=SortByValue(map);
		
		System.out.println(sortedMap);
	}
	
	public static TreeMap<String,Integer> SortByValue(
			HashMap<String,Integer> map){
		ValueComparator vc=new ValueComparator(map);
		TreeMap<String,Integer> sortedMap=new TreeMap<String,Integer>(vc);
		sortedMap.putAll(map);
		return sortedMap;
	}
	
	public static Map sortByValue1(Map unsortedMap) {
		Map sortedMap = new TreeMap(new ValueComparator1(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}
 
	
	
	
	public static Map sortByValue(Map unsortMap) {	 
		List list = new LinkedList(unsortMap.entrySet());
	 
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
							.compareTo(((Map.Entry) (o2)).getValue());
			}
		});
	 
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

}


class ValueComparator1 implements Comparator {
	 
	Map map;
 
	public ValueComparator1(Map map) {
		this.map = map;
	}
 
	public int compare(Object keyA, Object keyB) {
		Comparable valueA = (Comparable) map.get(keyA);
		Comparable valueB = (Comparable) map.get(keyB);
		return valueB.compareTo(valueA);
	}
}

class ValueComparator implements Comparator<String> {

	Map<String, Integer> map;

	public ValueComparator(Map<String, Integer> base) {
		this.map = base;
	}

	@Override
	public int compare(String a, String b) {
		if(map.get(a)>=map.get(b)){
			return -1;
		}else{
			return 1;
		}
		
		
	}

}
