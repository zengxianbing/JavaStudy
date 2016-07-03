package com.suggest;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Test22 {

	/*
	 * 用整数类型处理货币
	 * 
	 * 
	 * 使用BigDecimal
	 * 使用整形
	 */
	public static void main(String[] args) {

		System.out.println(10.00-9.60);
		
		NumberFormat f=new DecimalFormat("#.##");
		System.out.println(f.format(10.00-9.60));
	}

}
