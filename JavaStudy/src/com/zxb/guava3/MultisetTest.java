package com.zxb.guava3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultisetTest {

	@Test
     public void testWordCount(){
		 String strWorld="wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
	                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
	                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
		 String[] words=strWorld.split("\\|");
		 Map<String,Integer> countMap=new HashMap<String,Integer>();
		 for(String word:words){
			 Integer count=countMap.get(word);
			 if(count==null){
				 countMap.put(word, 1);
			 }else{
				 countMap.put(word, count+1);
			 }
				 
		 }
		 System.out.println("countMap:");
		 for(String key:countMap.keySet()){
			 System.out.println(key+" count:"+countMap.get(key));
		 }
	}
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testMultsetWordCount(){
		   String strWorld="wer|dfd|dd|dfd|dda|de|dr";
		   String[] words=strWorld.split("\\|");
		   List<String> wordList=new ArrayList<String>();
		   for(String word:words){
			   wordList.add(word);
		   }
		   Multiset<String> wordMultiset=HashMultiset.create();
		   wordMultiset.addAll(wordList);
		   for(String key:wordMultiset.elementSet()){
			   System.out.println(key+" count:"+wordMultiset.count(key));
		   }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
