package com.zxb.guava3;

import org.junit.Test;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

public class TestBaseRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("open:"+Range.open(1,10));
		System.out.println("closed:"+Range.closed(1, 10));
		System.out.println("closed:"+Range.closedOpen(1, 10));
		System.out.println("openClosed:"+Range.openClosed(1, 10));
		System.out.println("greaterThan:"+Range.greaterThan(10));
		System.out.println("atLeast:"+Range.atLeast(10));
		System.out.println("lessThat"+Range.lessThan(10));
		System.out.println("atMost:"+Range.atMost(10));
		System.out.println("all:"+Range.all());
		System.out.println("closed:"+Range.closed(10, 10));
		System.out.println("closedOpen"+Range.closedOpen(10, 10));
		System.out.println("open"+Range.open(10,10));
	}
	@Test
	public void testRange(){
		System.out.println("downTo"+Range.downTo(4, BoundType.OPEN));
		System.out.println("upTo"+Range.upTo(4, BoundType.CLOSED));
		System.out.println("range"+Range.range(1, BoundType.CLOSED,10, BoundType.OPEN));
		
	}
	
	@Test
	public void testContains(){
		
		System.out.println(Range.closed(1, 3).contains(2));
		System.out.println(Range.closed(1, 3).contains(4));
		System.out.println(Range.lessThan(5).contains(5));
		System.out.println(Range.closed(1, 4).containsAll(Ints.asList(1,2,3)));
		
	} 
	
	@Test
	public void testQuery(){
		System.out.println("hasLowerBound"+Range.closedOpen(4, 4).hasLowerBound());
		System.out.println("hasUpperBound"+Range.closedOpen(4, 4).hasUpperBound());
		System.out.println(Range.closedOpen(4, 4).isEmpty());
		System.out.println(Range.closed(4, 4).isEmpty());
		System.out.println(Range.openClosed(4, 4).isEmpty());
		System.out.println(Range.closed(3, 10).lowerEndpoint());
		System.out.println(Range.open(3, 10).lowerEndpoint());
		System.out.println(Range.closed(3, 10).upperEndpoint());
		System.out.println(Range.open(3, 10).upperEndpoint());
		System.out.println(Range.open(3, 10).upperBoundType());
		
	}
	
	@Test
	public void testEnclosed(){
		
		Range<Integer> rangeBase=Range.open(1, 4);
		Range<Integer> rangeClose=Range.closed(2,3);
		Range<Integer> rangeCloseOpen=Range.closedOpen(2,4);
		Range<Integer> rangeCloseOther=Range.closedOpen(2, 5);
		
		System.out.println("rangeBase:"+rangeBase+
				" Enclose:"+rangeBase.encloses(rangeClose)+" rangeClose:"+
				rangeClose);
		
		System.out.println("rangeBase:"+rangeBase+
				" Enclose:"+rangeBase.encloses(rangeCloseOpen)+" rangeCloseOpen:"+
				rangeCloseOpen);
		
		System.out.println("rangeBase:"+rangeBase+
				" Enclose:"+rangeBase.encloses(rangeCloseOther)+" rangeCloseOther:"+
				rangeCloseOther);
		
	}
	
	
	@Test
	public void testConnected(){
		
		System.out.println(Range.closed(3, 5).isConnected(Range.open(5, 10)));
		System.out.println(
		Range.closed(0, 9).isConnected(Range.closed(3, 4)));
		System.out.println(
		Range.closed(0, 5).isConnected(Range.closed(3, 9)));
		System.out.println(Range.open(3, 5).isConnected(
		 Range.open(5, 10)));
		System.out.println(Range.closed(1, 5).isConnected(Range.
				closed(6, 10)));
	}
	
	@Test
	public void testIntersection(){
		System.out.println(Range.closed(3, 5).intersection(
	    Range.open(5, 10)));
		System.out.println(Range.closed(0, 9).intersection(
			    Range.closed(3,4)));
			
		System.out.println(Range.closed(0, 5).intersection(
			    Range.closed(3,9)));
			
		System.out.println(Range.open(3, 5).intersection(
			    Range.open(5, 10)));
		System.out.println(Range.closed(1, 5).intersection(
			    Range.closed(6, 10)));
			
	}
	
	@Test
	public void testSpan(){
		System.out.println(Range.closed(3, 5).span(Range.open(5, 10)));
		System.out.println(Range.closed(0, 9).span(Range.closed(3,4)));
	    System.out.println(Range.closed(0, 5).span(Range.closed(3, 9)));
		System.out.println(Range.open(3, 5).span(Range.open(5, 10)));
		System.out.println(Range.closed(1, 5).span(Range.closed(6, 10)));
		System.out.println(Range.closed(1, 5).span(Range.closed(7, 10)));
	}
	
	
	
	
	
	
	
	

	
	
	

}
