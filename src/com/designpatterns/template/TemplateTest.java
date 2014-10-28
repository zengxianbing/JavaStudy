package com.designpatterns.template;

public class TemplateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Benchmark operation=new MethodBenchmark();
		long duration=operation.repeat(Integer.parseInt(args[0].trim()));
		System.out.println(duration);
	}

}
