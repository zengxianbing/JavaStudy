package com.programcreek;

class Super {
    String s;
 
    public Super(String s){
    	
    	this.s=s;
    	System.out.println("Super");
    }
}
 
public class Sub extends Super {

	int x=20;
	public Sub(String s){
		super(s);
		System.out.println("Sub");
	}
	
	/* public Sub(){
	    	System.out.println("Sub");
	    }*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sub s = new Sub("a");
	}

}
