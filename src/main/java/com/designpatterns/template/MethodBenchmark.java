package com.designpatterns.template;

public class MethodBenchmark extends Benchmark {

	@Override
	public void benchmark() {
		// TODO Auto-generated method stub

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println("i="+i);
		}
	}

}
