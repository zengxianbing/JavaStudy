package com.programcreek.designpatterns.prototype;

interface Prototype{
	void setSize(int x);
	void printSize();
}

class A implements Prototype,Cloneable{

	private int size;
	

	public A(int size) {
		super();
		this.size = size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	@Override
	public void printSize() {
		 System.out.println("Size: " + size);		
	}
	
	public A clone() throws CloneNotSupportedException{
		return (A)super.clone();
	}
	
}















public class PrototypeTest {
	
	
	  public static void main(String args[]) throws CloneNotSupportedException {
	  
		  A a=new A(1);
		  for(int i=2;i<10;i++){
			  Prototype temp=a.clone();
			  temp.setSize(1);
			  temp.printSize();
		  }
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
