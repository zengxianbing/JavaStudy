package com.suggest;

public class Test23 {

	
	public static final int LIGHT_SPEED=30*1000*1000;
	/*
	 * 不要让类型默认转换
	 */
	public static void main(String[] args) {

		long dis1=LIGHT_SPEED*1;
		long dis2=1L*LIGHT_SPEED*60*8;
		System.out.println(dis2);
				
		
	}

}
