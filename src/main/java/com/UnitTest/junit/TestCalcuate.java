package com.UnitTest.junit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalcuate {

	
	Calcuate cal;
	@Before
	public void setUp(){
		cal=new Calcuate();
	}
	
	@Test
	public void testAdd(){
		int rel=cal.add(12,33);
		assertEquals("加法有问题", rel,45);
	}
	
	@Test
	public void testMinus(){
		int rel=cal.minus(12,10);
		assertEquals("减法有问题", rel,2);
	}
	
	@Test
	public void testDivide(){
		int rel=cal.divide(12, 3);
		assertEquals("除法有问题", rel,4);
	}
	
	@Test
	public void testMul(){
		int rel=cal.mul(3, 4);
		assertEquals("乘法有问题", rel,122);
	}
	
	
	@Test(expected=ArithmeticException.class)
	public void testDivideException(){
		int rel=cal.divide(20, 10);
	}
	
	
	@Test(timeout=300)
	public void testTime(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHamcrest(){
		//assertThat(50,greaterThan(20));
		//assertThat(50,allOf(greaterThan(20),lessThan(40)));
		//assertThat("abc.txt",endsWith("txt"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
