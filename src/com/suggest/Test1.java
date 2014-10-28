package com.suggest;

import java.util.Random;

public class Test1 {

	public static void main(String[] args) {

		System.out.println(Const.RAND_CONST);
	}

}
interface Const{
	public static  final int RAND_CONST=new Random().nextInt();
}
