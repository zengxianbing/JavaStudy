package com.programcreek.simpleJAVA;

import com.programcreek.simpleJAVA.Outer.Inner;

class Outer{
	private int x=100;
	
	private int y=200;
	public  void doStuff(){
		class MyInner{
			public void seeOuter(){
				System.out.println(" y i s " + y);
			}
			
			
		}
		MyInner i=new MyInner();
		i.seeOuter();
	}
	public void makeInner(){
		Inner in=new Inner();
		in.seeOuter();
	}
	 class Inner{
		void go(){
			System.out.println(" Inner c l a s s r e f e r enc e i s : " + this);
		}
		
		
		public void seeOuter(){
			System.out.println("Outer x i s " + x);
			System.out.println(" Inner c l a s s r e f e r enc e i s " + this);
			System.out.println("Outer c l a s s r e f e r enc e i s " + Outer . this);
		}
	}
}
public class InnerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*Outer.Inner n=new Outer.Inner();
		n.go();*/
		
		
		/*Outer o=new Outer();
		Inner i=o.new Inner();
		i.seeOuter();*/
		
		
		Outer o=new Outer();
		o.doStuff();
		
		
		
		
	}

}
