package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.HashMap;
import java.util.Stack;

public class VALID_PARENTHE_SES {

	public static boolean isValid(String s){
		HashMap<Character,Character> map=new HashMap<Character,Character>();
		
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		

		Stack<Character> stack=new Stack<Character>();
		
		for(int i=0;i<s.length();i++){
			char curr=s.charAt(i);
			
			if(map.keySet().contains(curr)){
				stack.push(curr);
			}else if(map.values().contains(curr)){
				if(!stack.empty()&&map.get(stack.peek())==curr){
					stack.pop();
				}else{
					return false;
				}
			}
			
		}
		return stack.empty();
		
	}
	
	
	public static boolean isValid1(String s){
		char[] charArray=s.toCharArray();
		HashMap<Character,Character> map=new HashMap<Character,Character>();
		
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		

		Stack<Character> stack=new Stack<Character>();
		
		for(Character curr:charArray){
			
			if(map.keySet().contains(curr)){
				stack.push(curr);
			}else if(map.values().contains(curr)){
				if(!stack.empty()&&map.get(stack.peek())==curr){
					stack.pop();
				}else{
					return false;
				}
			}
			
		}
		return stack.empty();
		
	}
}
