package com.programcreek.simpleJAVA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class TreeMapSortTest {

	@Test
	public void TreeMapSortTest() {
		Map<String, String> map = new TreeMap<String, String>(
				new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						return o2.compareTo(o1);
					}

				});

		map.put("month", "The month");
		map.put("bread", "The bread");
		map.put("attack", "The attack");

		Set<String> keySet = map.keySet();
		Iterator<String> iter = keySet.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ":" + map.get(key));
		}

	}

	@Test
	public void TreeMapSortValueTest() {

		List<Map.Entry<String, String>> mappingList = null;
		Map<String, String> map = new TreeMap<String, String>();
		map.put("aaaa", "month");
		map.put("bbbb", "bread");
		map.put("cccc", "attack");

		mappingList = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		Collections.sort(mappingList,
				new Comparator<Map.Entry<String, String>>() {

					@Override
					public int compare(Entry<String, String> mapping1,
							Entry<String, String> mapping2) {
						// TODO Auto-generated method stub
						return mapping1.getValue().compareTo(
								mapping2.getValue());
					}

				});
		for (Entry<String, String> entry : mappingList) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

	@Test
	public void TreeMapSortKeyTest() {
		List<Map.Entry<String, String>> mappingList = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaaa", "month");
		map.put("bbbb", "bread");
		map.put("cccc", "attack");

		mappingList = new ArrayList<Map.Entry<String, String>>(map.entrySet());

		Collections.sort(mappingList,
				new Comparator<Map.Entry<String, String>>() {

					@Override
					public int compare(Entry<String, String> mapping1,
							Entry<String, String> mapping2) {
						// TODO Auto-generated method stub
						return mapping1.getKey().compareTo(mapping2.getKey());
					}

				});

		for (Entry<String, String> entry : mappingList) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

	}

	
	
	
	
	
	
	
	
	
	
	public void test1(){
		Map<String,String> map=new TreeMap<String,String>(
				new Comparator<String>(){

					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						return o2.compareTo(o1);
					}
			
		});
		
		map.put("b","ccccc");
		map.put("d","aaaaa");
		map.put("c","bbbbb");
		map.put("a","dddd");
		
		Set<String> keySet=map.keySet();
		Iterator<String> iter=keySet.iterator();
		while(iter.hasNext()){
			String key=iter.next();
			System.out.println(key+":"+map.get(key));
		}
	}
	
	
	@Test
	public void test2(){
		Map<String,String> map=new TreeMap<String,String>();
		map.put("b","ccccc");
		map.put("d","aaaaa");
		map.put("c","bbbbb");
		map.put("a","dddd");
		List<Map.Entry<String, String>> list=new
		ArrayList<Map.Entry<String,String>>(map.entrySet());
		Collections.sort(list, new 
			Comparator<Map.Entry<String, String>>(){

				@Override
				public int compare(Entry<String, String> o1,
						Entry<String, String> o2) {
					// TODO Auto-generated method stub
					return o1.getValue().compareTo(o2.getValue());
				}
			
		});
		
		for (Entry<String, String> entry : list) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
