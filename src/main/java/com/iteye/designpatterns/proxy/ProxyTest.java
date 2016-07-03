package com.iteye.designpatterns.proxy;

interface Sourceable {
	public void method();
}

class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("the original method!");
	}

}

class Proxy implements Sourceable {

	private Source source;

	public Proxy() {
		super();
		this.source = new Source();
	}

	@Override
	public void method() {

		before();
		source.method();
		after();

	}

	private void after() {
		System.out.println("after proxy!");
	}

	private void before() {
		System.out.println("before proxy!");
	}
}

public class  ProxyTest{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Sourceable source = new Proxy();
		source.method();
	}

}
