package com.programcreek.simpleJAVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.management.ObjectName;

public class sort {

	
	public void sortTest(){
		List<ObjectName> list=new ArrayList<ObjectName>();
        Collections.sort(list, new Comparator<ObjectName>(){

			@Override
			public int compare(ObjectName o1, ObjectName o2) {
				return o1.toString().compareTo(o2.toString());
			}
        	
        });
        
        
        
        
        
        ObjectName[] arr=new ObjectName[10];
        Arrays.sort(arr, new Comparator<ObjectName>(){

			@Override
			public int compare(ObjectName o1, ObjectName o2) {

				return o1.toString().compareTo(o2.toString());
			}
        	
        });
        
       Set<ObjectName> sortedSet=new TreeSet<ObjectName>(
    		   new Comparator<ObjectName>(){

				@Override
				public int compare(ObjectName o1, ObjectName o2) {
					return o1.toString().compareTo(o2.toString());
				}
    			   
    		   }); 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	}
}
