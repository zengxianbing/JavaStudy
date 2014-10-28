package com.zxb.guava3;

import org.junit.Test;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;

public class TableTest {

	@Test
	public void TableTest(){
		Table<String,Integer,String> aTable=HashBasedTable.create();
		for(char a='A';a<='C';a++){
			for(Integer b=1;b<=3;b++){
				aTable.put(Character.toString(a), b, String.format("%c%d",a,b));
			}
		}
		
		System.out.println(aTable.column(2));
		System.out.println(aTable.row("B"));
		System.out.println(aTable.get("B", 2));
		System.out.println(aTable.contains("D", 1));
		System.out.println(aTable.containsColumn("C"));
		System.out.println(aTable.containsRow("C"));
		System.out.println(aTable.columnMap());
		System.out.println(aTable.rowMap());
		System.out.println(aTable.remove("B", 3));
	}
	
	@Test
	public void ClassToInstanceMapTest(){
		ClassToInstanceMap<String> classToInstanceMapString=
	     MutableClassToInstanceMap.create();
		ClassToInstanceMap<Person> classToInstanceMap=
			     MutableClassToInstanceMap.create();
		Person person=new Person("peida",20);
		System.out.println("person name:"+person.name+
				" age:"+person.age);
		classToInstanceMapString.put(String.class, "peida");
		System.out.println("string:"+classToInstanceMapString.getInstance(String.class));
		
		classToInstanceMap.put(Person.class, person);
		Person person1=classToInstanceMap.getInstance(Person.class);
		System.out.println("person1 name:"+person1.name+
				" age:"+person1.age);
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	class Person{
		public String name;
		public int age;
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
	}
	
	@Test
	public void RangeSetTest(){
		RangeSet<Integer> rangeSet=TreeRangeSet.create();
	    rangeSet.add(Range.closed(1, 10));	
	    System.out.println("rangeSet:"+rangeSet);
	    rangeSet.add(Range.closedOpen(11, 15));
	    System.out.println("rangeSet:"+rangeSet);
	    rangeSet.add(Range.open(15, 20));
	    System.out.println("rangeSet:"+rangeSet);
	    rangeSet.add(Range.openClosed(0, 0));
	    System.out.println("rangeSet:"+rangeSet);
	    rangeSet.add(Range.open(5, 10));
	    System.out.println("rangeSet:"+rangeSet);
	    
	}
	@Test
	public void RangeMapTest(){
	
		RangeMap<Integer,String> rangeMap=TreeRangeMap.create();
		rangeMap.put(Range.closed(1, 10), "foo");
		System.out.println("rangeMap:"+rangeMap);
		rangeMap.put(Range.open(3, 6), "bar");
		System.out.println("rangeMap:"+rangeMap);
		rangeMap.put(Range.open(10, 20), "foo");
		System.out.println("rangeMap:"+rangeMap);
		rangeMap.remove(Range.closed(5, 11));
		System.out.println("rangeMap:"+rangeMap);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
