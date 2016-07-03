package com.zxb.Concurrency.oracle;

import java.util.concurrent.ThreadLocalRandom;

public class TheadLocalRandomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int r=ThreadLocalRandom.current().nextInt();
		System.out.println("r="+r);
	}

}
