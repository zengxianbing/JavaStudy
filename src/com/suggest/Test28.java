package com.suggest;

import java.util.Scanner;

public class Test28 {

	/*
	 * 优先使用整型池
	 */
	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		while(input.hasNextInt()){
			int ii=input.nextInt();
			Integer i=new Integer(ii);
			Integer j=new Integer(ii);
			System.out.println((i==j));
			
			
			
			i=ii;
			j=ii;
			System.out.println((i==j));
			
			i=Integer.valueOf(ii);
			j=Integer.valueOf(ii);
			System.out.println((i==j));
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}

}
