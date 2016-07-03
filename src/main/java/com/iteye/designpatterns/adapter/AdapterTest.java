package com.iteye.designpatterns.adapter;

class Source {
	public void method1() {
		System.out.println("this is original method!");
	}
}

interface Targetable {
	public void method1();

	public void method2();
}

class Adapter extends Source implements Targetable {

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

}

public class AdapterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Targetable target = new Adapter();
		target.method1();
		target.method2();
	}

}

class Wrapper implements Targetable {

	private Source source;

	public Wrapper(Source source) {
		super();
		this.source = source;
	}

	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

}

class AdapterTest2 {
	public static void main(String[] args) {

		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}

interface Sourceable {
	public void method1();

	public void method2();
}

abstract class Wrapper2 implements Sourceable {
	public void method1() {
	}

	public void method2() {
	}
}

class SourceSub1 extends Wrapper2 {
	public void method1() {
		System.out.println("the sourceable interface's first Sub1!");
	}
}

class SourceSub2 extends Wrapper2 {
	public void method2() {
		System.out.println("the sourceable interface's second Sub2!");
	}
}

class WrapperTest {
	public static void main(String[] args) {
		Sourceable source1 = new SourceSub1();
		Sourceable source2 = new SourceSub2();

		source1.method1();
		source1.method2();
		source2.method1();
		source2.method2();
	}

}
