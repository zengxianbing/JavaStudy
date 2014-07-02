package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.Set;

public class WORD_BREAK {

	public boolean wordBreak(String s,Set<String> dict){
		return wordBreakHelper(s,dict,0);
	}
	
	public boolean wordBreakHelper(String s,Set<String> dict,
			int start){
		if(start==s.length())
			return true;
		
		for(String a:dict){
			int len=a.length();
			int end=start+len;
			
			if(end>s.length())
				continue;
			
			if(s.substring(start, start+len).equals(a)){
				if(wordBreakHelper(s,dict,start+len))
					return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean wordBreak2(String s,Set<String> dict){
		boolean[] t=new boolean[s.length()+1];
		t[0]=true;
		
		for(int i=0;i<s.length();i++){
			if(!t[i])
				continue;
			
			for(String a:dict){
				int len=a.length();
				int end=i+len;
				if(end>s.length())
					continue;
				if(s.substring(i, end).equals(a)){
					t[end]=true;
				}
			}
		}
		return t[s.length()];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
