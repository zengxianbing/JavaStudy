package com.iteye.designpatterns.bridge;

interface Sourceable{
	public void method();
} 

class SourceSub1 implements Sourceable{

	@Override
	public void method() {
		 System.out.println("this is the first sub!"); 		
	}
	
}

class SourceSub2 implements Sourceable{

	@Override
	public void method() {
		   System.out.println("this is the second sub!");  		
	}
	
}

abstract class Bridge{
	private Sourceable source;
	
	public Sourceable getSource() {
		return source;
	}

	public void setSource(Sourceable source) {
		this.source = source;
	}

	public void method(){
	 source.method();
	}
}

class MyBridge extends Bridge{
	public void method(){
		getSource().method();
	}
}







































































































public class BridgeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Bridge bridge=new MyBridge();
		
		Sourceable source1=new SourceSub1();
		bridge.setSource(source1);
		bridge.method();
		
		Sourceable source2=new SourceSub1();
		bridge.setSource(source2);
		bridge.method();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
