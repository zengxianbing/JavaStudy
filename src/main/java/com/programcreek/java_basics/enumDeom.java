package com.programcreek.java_basics;

 enum Color{
	RED,YELLOW,BLUE;
}

enum Color1{
	RED(1),
	YELLOW(2),
	BLUE(3);
	
	private int value;
	private Color1(){}
	
	private Color1(int i){
		this.value=i;
	}
	
	public void printValue(){
		System.out.println(this.value);
	}
}

public class enumDeom {

	
	public void test1(){
	
		for(Color color:Color.values()){
			System.out.println(color);
		} 
	}
	
	
	
	public void test2(){
		for(Color1 color:Color1.values()){
			color.printValue();
		}
	}
}
