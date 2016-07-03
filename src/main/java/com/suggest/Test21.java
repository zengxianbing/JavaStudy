package com.suggest;

import java.util.Scanner;

public class Test21 {

	/*
	 * 用偶数判断，不用奇数判断
	 */
	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		while(input.hasNextInt()){
			int i=input.nextInt();
			String str=i+"->"+(i%2==1?"奇数":"偶数");
//			String str=i+"->"+(i%2==0?"偶数":"奇数");
			System.out.println(str);
		}
	}
	
	
	public static int remainder(int dividend,int divisor){
		return dividend-dividend/divisor*divisor;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
