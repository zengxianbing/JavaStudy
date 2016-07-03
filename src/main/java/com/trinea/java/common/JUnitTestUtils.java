package com.trinea.java.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class JUnitTestUtils {

	
	 /**
     * 若actual与expecteds中之一相等便返回true，否则返回false
     * 
     * @param actual
     * @param expecteds
     * @return
     */
	public static boolean assertEquals(String actual,String...expecteds){
		for(String expected:expecteds){
			if(actual.equals(expected)){
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	   /**
     * 比较两个map
     * 
     * @param actual
     * @param expected
     * @return
     */
	public static boolean assertEquals(Map actual,Map expected){
		if(actual==null||expected==null){
			return (actual==null&&expected==null);
		}
		if(actual.size()==0||expected.size()==0){
			return (actual.size()==0&&expected.size()==0);
		}
		
		if(actual.size()==expected.size()){
			Iterator actualIterator=actual.entrySet().iterator();
			while(actualIterator.hasNext()){
				Entry entry=(Entry) actualIterator.next();
				if(entry.getValue()!=null){
					if(!entry.getValue().equals(expected.get(entry.getKey()))){
						return false;
					}
				}else if(expected.get(entry.getKey())!=null){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
