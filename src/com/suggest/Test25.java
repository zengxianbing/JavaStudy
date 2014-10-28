package com.suggest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test25 {

	/*
	 * 不要让四舍五入亏了一方
	 */
	public static void main(String[] args) {

		BigDecimal d=new BigDecimal(8888888);
		BigDecimal r=new BigDecimal(0.0018*3);
		BigDecimal i=d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
		
	}

}
