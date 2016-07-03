package com.suggest;

import java.text.NumberFormat;

public class Test4 {

	/*
	 * 
	 * 避免带有变长参数的重载
	 */
	public void calPrice(int price, int discount) {

		float knockdownprice = price * discount / 100.0F;

		System.out.println(formateCurrency(knockdownprice));

	}

	private String formateCurrency(float price) {
		return NumberFormat.getCurrencyInstance().format(price);

	}

	public static void main(String[] args) {

		Test4 test4 = new Test4();
		test4.calPrice(49900, 75);

	}

}
