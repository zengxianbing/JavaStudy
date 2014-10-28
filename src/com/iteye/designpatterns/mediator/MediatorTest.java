package com.iteye.designpatterns.mediator;

interface Mediator {
	public void createMediator();

	public void workAll();
}

abstract class User {
	private Mediator mediator;

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public User(Mediator mediator) {
		super();
		this.mediator = mediator;
	}

	public abstract void work();
}

class MyMediator implements Mediator {

	private User user1;
	private User user2;

	
	public User getUser1() {
		return user1;
	}

	public User getUser2() {
		return user2;
	}

	@Override
	public void createMediator() {

		user1 = new User1(this);
		user2 = new User2(this);
	}

	@Override
	public void workAll() {

		user1.work();
		user2.work();
	}

}

class User1 extends User {

	public User1(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work() {
		System.out.println("user1 exe!");
	}

}

class User2 extends User {

	public User2(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void work() {
		System.out.println("user2 exe!");
	}

}

public class MediatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}

}
