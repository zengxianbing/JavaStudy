package com.iteye.designpatterns.observer;

import java.util.Enumeration;
import java.util.Vector;

interface Observer {
	public void updat();
}

class Observer1 implements Observer {

	@Override
	public void updat() {
		System.out.println("observer1 has received!");
	}

}

class Observer2 implements Observer {

	@Override
	public void updat() {
		System.out.println("observer2 has received!");
	}

}

interface Subject {
	public void add(Observer observer);

	public void del(Observer observer);

	public void notifyObservers();

	public void operation();
}

abstract class AbstractSubject implements Subject {

	private Vector<Observer> vector = new Vector<Observer>();

	public void add(Observer observer) {
		vector.add(observer);
	}

	public void del(Observer observer) {
		vector.remove(observer);
	}

	public void notifyObservers() {
		Enumeration<Observer> enumo = vector.elements();

		while (enumo.hasMoreElements()) {
			enumo.nextElement().updat();
		}
	}

}

class MySubject extends AbstractSubject {

	@Override
	public void operation() {
		System.out.println("update self!");
		notifyObservers();
	}

}

public class ObserverTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());
		sub.operation();
	}

}
