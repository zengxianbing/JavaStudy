package com.zxb.Performance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayListVSLinkedList {

	List<Integer> list=null;
	  @Before  
	    public void setUp() throws Exception {  
	      list=new ArrayList();
	      list.add(1);
	      list.add(2);
	      list.add(3);
	      list.add(4);
	    }  
	  
	    @After  
	    public void tearDown() throws Exception {  
	        System.out.println("一个测试结束");  
	    }  
	
	@Test
	public void testArrayList(){
		
		for(Integer j:list){
			System.out.print(j);
			System.out.println();
		}
		
		
		for(Iterator<Integer> iterator=list.iterator();iterator.hasNext();)
		{
			System.out.print(iterator.next());
			System.out.println();
		}		
	
	    
	    
		Iterator<Integer> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next());
			System.out.println();
		}
		

		for(int j=0;j<list.size();j++){
			System.out.print(list.get(j));
			System.out.println("  ");
		}
		
		
		for(int j=list.size()-1;j>=0;j--){
			System.out.print(list.get(j));
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
