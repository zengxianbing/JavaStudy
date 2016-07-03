package com.zxb.guava3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Preconditions;

public class PreconditionsTest {

	@Test
	public void PreConditions(){
		  getPersonByPrecondition(8,"peida");
	        
	        try {
	            getPersonByPrecondition(-9,"peida");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	            getPersonByPrecondition(8,"");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	            getPersonByPrecondition(8,null);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        List<Integer> intList=new ArrayList<Integer> ();
	        for(int i=0;i<10;i++){            
	            try {
	                checkState(intList,9);
	                intList.add(i);
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }

	        }
	        
	        try {
	            checkPositionIndex(intList,3);    
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	            checkPositionIndex(intList,13);    
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	            checkPositionIndexes(intList,3,7);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	            checkPositionIndexes(intList,3,17);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	            checkPositionIndexes(intList,13,17);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	            checkElementIndex(intList,6);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        
	        try {
	            checkElementIndex(intList,16);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	}
	public static void getPersonByPrecondition(int age,String name){
		Preconditions.checkNotNull(name, "name为Null");
		Preconditions.checkArgument(name.length()>0, "name为\'\'");
		Preconditions.checkArgument(age>0, "age必须大于0");

		System.out.println("a person age:"+age+",name:"+name);
	}
	
	public static void checkState(List<Integer> intList,int index){
		Preconditions.checkState(intList.size()<index, "intList size不能大于"+index);
		
	}
	
	public static void checkPositionIndex(List<Integer> intList,int index){
		Preconditions.checkPositionIndex(index, intList.size(),"index "+index+" 不在 list中， List size为："+intList.size());
	}
	  public static void checkPositionIndexes(List<Integer> intList,int start,int end) throws Exception{
	        Preconditions.checkPositionIndexes(start, end, intList.size());
	    }
	    
	    public static void checkElementIndex(List<Integer> intList,int index) throws Exception{
	        Preconditions.checkElementIndex(index, intList.size(),"index 为 "+index+" 不在 list中， List size为： "+intList.size());
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
