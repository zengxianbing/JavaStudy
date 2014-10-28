package com.zxb.guava;

import java.util.Collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class teststuScoreMultimap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Multimap<String,StudentScore>  scoreMultimap=ArrayListMultimap.create();
		
		for(int i=10;i<20;i++){
			StudentScore studentScore=new StudentScore();
			studentScore.CourseId=1001+i;
			studentScore.score=100-i;
			scoreMultimap.put("pedia", studentScore);
			
		}
		System.out.println("scoreMultimap:"+scoreMultimap.size());
		System.out.println("scoreMultimap:"+scoreMultimap.keys());
		
		Collection<StudentScore> studentScore=scoreMultimap.get("peida");
		studentScore.clear();
		StudentScore studentScoreNew=new StudentScore();
		studentScoreNew.CourseId=1034;
		studentScoreNew.score=67;
		studentScore.add(studentScoreNew);
		
		System.out.println("scoreMultimap:"+scoreMultimap.size());
		System.out.println("scoreMultimap:"+scoreMultimap.keys());
		
		System.out.println("scoreMultimap: values"+scoreMultimap.values());
		
		StudentScore studentScore2=new StudentScore();
		studentScore2.CourseId=1045;
		studentScore2.score=56;
		scoreMultimap.put("jerry", studentScore2);
		
		
		System.out.println("scroeMultimap:"+scoreMultimap.size());
		System.out.println("scoreMultimap:"+scoreMultimap.keys());
		
		for(StudentScore stuScore:scoreMultimap.values()){
			System.out.println("stuScore one:"+stuScore.CourseId+" score: "+stuScore.score);
		}
		
		scoreMultimap.remove("jeryy", studentScore2);
		System.out.println("scoreMultimap:"+scoreMultimap.get("jerry"));
		scoreMultimap.put("harry", studentScore2);
		scoreMultimap.removeAll("harry");
		
		
		System.out.println("scoreMultimap:"+scoreMultimap.size());
		
		System.out.println("scoreMultimap:"+scoreMultimap.get("harry"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


