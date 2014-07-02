package com.programcreek.designpattern;





















interface Human{
	public void Talk();
	public void Walk();
}


class Boy implements Human{

	@Override
	public void Talk() {
		System.out.println("Boy is talking...");				
	}

	@Override
	public void Walk() {
		System.out.println("Boy is walking...");		
	}
	
}


class Girl implements Human{

	@Override
	public void Talk() {
		System.out.println("Girl is talking...");		
	}

	@Override
	public void Walk() {
		System.out.println("Girl is walking...");		
	}
	
}


class HumanFactory{
	public static Human createHuman(String m){
		Human p=null;
		if(m=="boy"){
			p=new Boy();
			
		}else if(m=="left"){
			p=new Girl();
		}
		return p;
	}
}





















public class Factory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
