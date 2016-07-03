package com.zxb.guava2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Table;

public class TestGuava {

	@Test
	public void BimapTest() {
		BiMap<Integer, String> logfileMap = HashBiMap.create();
		logfileMap.put(1, "a.log");
		logfileMap.put(2, "2.log");
		logfileMap.put(3, "c.log");
		logfileMap.put(4, "d.log");
		logfileMap.put(6, "6.log");
		logfileMap.put(7, "7.log");
		logfileMap.put(8, "8.log");
		logfileMap.put(9, "9.log");
		logfileMap.put(10, "10.log");
		logfileMap.put(11, "11.log");
		logfileMap.put(12, "12.log");
		logfileMap.put(13, "13.log");
		logfileMap.forcePut(5, "d.log");
		System.out.println("logfileMap:" + logfileMap);
		BiMap<String, Integer> filelogMap = logfileMap.inverse();
		System.out.println("filelogMap:" + filelogMap);

		logfileMap.put(6, "g.log");

		System.out.println("logfileMap:" + logfileMap);
		System.out.println("filelogMap:" + filelogMap);

	}

	@Test
	public void logMapTest() {
		Map<Integer, String> logfileMap = Maps.newHashMap();
		logfileMap.put(1, "a.log");
		logfileMap.put(2, "b.log");
		logfileMap.put(3, "c.log");
		System.out.println("logfileMap:" + logfileMap);
		Map<String, Integer> logfileInverseMap = Maps.newHashMap();
		logfileInverseMap = getInverseMap(logfileMap);
		System.out.println("logfileInverseMap:" + logfileInverseMap);

	}

	public static <S, T> Map<T, S> getInverseMap(Map<S, T> map) {
		Map<T, S> inverseMap = new HashMap<T, S>();
		for (Entry<S, T> entry : map.entrySet()) {
			inverseMap.put(entry.getValue(), entry.getKey());
		}
		return inverseMap;
	}

	Map<String, List<StudentScore>> StudentScoreMap = new HashMap<String, List<StudentScore>>();

	@Test
	public void MultimapTest() {
 
		for(int i=10;i<20;i++){
			
			StudentScore studentScore=new StudentScore();
			studentScore.CourseId=1001+i;
			
			studentScore.score=100-i;
			addStudentScore("peida",studentScore);
			System.out.println("StudentScoreMap:"+StudentScoreMap.size());
			System.out.println("StudentScoreMap:"+StudentScoreMap.containsKey("pdida"));
			System.out.println("StudentScoreMap:"+StudentScoreMap.containsKey("jerry"));
			System.out.println("StudentScoreMap:"+StudentScoreMap.size());
			System.out.println("StudentScoreMap:"+StudentScoreMap.get("peida").size());
			List<StudentScore> StudentScoreList=StudentScoreMap.get("peida");
			if(StudentScoreList!=null&&StudentScoreList.size()>0){
				for(StudentScore stuScore:StudentScoreList){
					System.out.println("stuScore one:"+stuScore.CourseId+"  score:"+stuScore.score);
				}
			}
			
			
			
			
			
			
			
			
			
			
			
				
		}
	
	}

	public void addStudentScore(final String stuName,
			final StudentScore studentScore) {
		List<StudentScore> stuScore = StudentScoreMap.get(stuName);
		if (stuScore == null) {
			stuScore = new ArrayList<StudentScore>();
			StudentScoreMap.put(stuName, stuScore);
		}
		stuScore.add(studentScore);
	}

	
	@Test
	public void TableTest(){
		Table<String,Integer,String> aTable=HashBasedTable.create();
		for(char a='A';a<'C';a++){
			for(Integer b=1;b<=3;b++){
				aTable.put(Character.toString(a),b, String.format("%c%d", a,b));
			}
		}
		System.out.println(aTable.column(2));
		System.out.println(aTable.row("B"));
		System.out.println(aTable.get("B",2));
		System.out.println(aTable.contains("D", 1));
		System.out.println(aTable.containsColumn(3));
		System.out.println(aTable.containsRow("C"));
		System.out.println(aTable.columnMap());
		System.out.println(aTable.rowMap());
		System.out.println(aTable.remove("B", 3));
		System.out.println(aTable.row("B"));
		System.out.println(aTable.row("B"));
	}
	@Test
	public void testClassToInstanceMap(){
	
		ClassToInstanceMap<String> classToInstanceMapString=MutableClassToInstanceMap.create();
		ClassToInstanceMap<Person> classToInstanceMap=MutableClassToInstanceMap.create();
		Person person=new Person("peida",20);
		System.out.println("person name:"+person.name+" age:"+person.age);
		
		classToInstanceMapString.put(String.class, "peida");
		System.out.println("string:"+	classToInstanceMapString.get(String.class));
		classToInstanceMap.put(Person.class,person);
		Person person1=	classToInstanceMap.getInstance(Person.class);
		System.out.println("person1 name:"+person1.name+"age:"+person1.age);
		
		
		
		
		
		
		
		
		
		
	}
	}
	class Person {
	    public String name;
	    public int age;

	    Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }
	    @Test
	    public void testGuavaImmutable1(){
	    	List<String> list=new ArrayList<String>();
	    	list.add("a");
	    	list.add("b");
	    	list.add("c");
	    	System.out.println("list:"+list);
	    	ImmutableList<String> imList=ImmutableList.copyOf(list);
	    	System.out.println("imlist:"+imList);
	    	
	    	ImmutableList<String> imOfList=ImmutableList.of("peida","jerry","harry");
	    	System.out.println("imOfList:"+imOfList);
	    	
	    	
	    	ImmutableSortedSet<String> imSortList=ImmutableSortedSet.of("a","b","c","d","e","f");
	    	System.out.println("imSortList:"+imSortList);
	    	
	    	list.add("baby");
	    	System.out.println("list add a item after list:"+list);
	      	System.out.println("list add a item after imList:"+imList);  
	      	ImmutableSet<Color> imColorSet=ImmutableSet.<Color>builder()
	      			.add(new Color(0,255,255)).add(new Color(0,255,255)).build();
	    	
	    	
	      	System.out.println("imColorSet:"+imColorSet);
	    	
	    	
	    	
	    	
	    	
	    } 
}
