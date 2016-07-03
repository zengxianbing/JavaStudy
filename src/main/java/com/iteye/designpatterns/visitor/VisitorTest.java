package com.iteye.designpatterns.visitor;

interface Visitor {
	public void visit(Subject sub);
}

class MyVisitor implements Visitor {

	@Override
	public void visit(Subject sub) {
		System.out.println("visit the subject：" + sub.getSubject());
	}

}

interface Subject {
	public void accept(Visitor visitor);

	public String getSubject();
}

class MySubject implements Subject {

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
		return "love";
	}

}

public class VisitorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Visitor visitor = new MyVisitor();
		Subject sub = new MySubject();
		sub.accept(visitor);
	}

}
