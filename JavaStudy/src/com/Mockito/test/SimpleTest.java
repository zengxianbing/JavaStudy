package com.Mockito.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;



public class SimpleTest {

	  @Test  
	    public void simpleTest(){  
	          
	        //创建mock对象，参数可以是类，也可以是接口  
	        List<String> list = mock(List.class);  
	          
	        //设置方法的预期返回值  
	        when(list.get(0)).thenReturn("helloworld");  
	      
	        String result = list.get(0);  
	          
	        //验证方法调用(是否调用了get(0))  
	        verify(list).get(0);  
	          
	        //junit测试  
	        Assert.assertEquals("helloworld", result);  
	    }  
	  
	  
	  @Test  
	  public void argumentMatcherTest(){  
	        
	      List<String> list = mock(List.class);  
	        
	      when(list.get(anyInt())).thenReturn("hello","world");  
	        
	      String result = list.get(0)+list.get(1);  
	        
	      verify(list,times(2)).get(anyInt());  
	        
	      Assert.assertEquals("helloworld", result);  
	        
	  }  
	  
	  @Test  
	  public void argumentMatcherTest2(){  
	        
	      Map<Integer,String> map = mock(Map.class);  
	      when(map.put(anyInt(),anyString())).thenReturn("hello");//anyString()替换成"hello"就会报错  
	      map.put(1, "world");  
	      verify(map).put(eq(1), eq("world")); //eq("world")替换成"world"也会报错  
	        
	  }  
	  
	  @Test  
	  public void verifyInvocate(){  
	        
	      List<String> mockedList = mock(List.class);  
	      //using mock   
	       mockedList.add("once");  
	       mockedList.add("twice");  
	       mockedList.add("twice");  
	         
	       mockedList.add("three times");  
	       mockedList.add("three times");  
	       mockedList.add("three times");  
	         
	       /** 
	        * 基本的验证方法 
	        * verify方法验证mock对象是否有没有调用mockedList.add("once")方法 
	        * 不关心其是否有返回值，如果没有调用测试失败。 
	        */  
	       verify(mockedList).add("once");   
	       verify(mockedList, times(1)).add("once");//默认调用一次,times(1)可以省略  
	         
	         
	       verify(mockedList, times(2)).add("twice");  
	       verify(mockedList, times(3)).add("three times");  
	         
	       //never()等同于time(0),一次也没有调用  
	       verify(mockedList, times(0)).add("never happened");  
	         
	       //atLeastOnece/atLeast()/atMost()  
	       verify(mockedList, atLeastOnce()).add("three times");  
	       verify(mockedList, atLeast(2)).add("twice");  
	       verify(mockedList, atMost(5)).add("three times");  
	    
	  }  
	  @Test
	public void  test1(){
		  
		//mock creation  
		  List mockedList = mock(List.class);  
		    
		  // using mock object  
		  mockedList.add("one");  
		  mockedList.clear();  
		  mockedList.add("3"); // no verify? OK  
		    
		  // verification  
		  verify(mockedList).add("one");  
		  verify(mockedList).clear();  
		  // verify(mockedList).add("2"); // this will throw an exception  
	  }
	  
	  @Test
		public void  test2(){
		  
		  
		// You can mock concrete classes, not only interfaces  
		  LinkedList mockedList = mock(LinkedList.class);  
		    
		  // stubbing  
		  when(mockedList.get(0)).thenReturn("first");  
		  when(mockedList.get(1)).thenThrow(new RuntimeException());  
		    
		  // following prints "first"  
		  System.out.println(mockedList.get(0));  
		  // following throws runtime exception  
		  System.out.println(mockedList.get(1));  
		  // following prints "null" because get(999) was not stubbed  
		  System.out.println(mockedList.get(999));  
		    
		  // Although it is possible to verify a stubbed invocation, usually it's just redundant  
		  // See http://monkeyisland.pl/2008/04/26/asking-and-telling  
		  verify(mockedList, atLeast(2)).get(0);  
	  }
	  
	  
	  @Test
		public void  test3(){
		  LinkedList mockedList = mock(LinkedList.class);  
		// stubbing using built-in anyInt() argument matcher  
		  when(mockedList.get(anyInt())).thenReturn("element");  
		    
		  // following prints "element"  
		  System.out.println(mockedList.get(999));  
		    
		  // you can also verify using an argument matcher  
		  verify(mockedList).get(anyInt());  
	  }
	  
	  @Test
		public void iterator_will_return_hello_world(){
			//arrange
			Iterator i=mock(Iterator.class);
			when(i.next()).thenReturn("Hello").thenReturn("World");
			//act
			String result=i.next()+" "+i.next();
			//assert
			assertEquals("Hello World", result);
		}
}
