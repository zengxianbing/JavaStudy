package com.iteye.designpatterns.command;

interface Command {
	public void exe();
}

class MyCommand implements Command {

	private Receiver receiver;

	public MyCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}

	@Override
	public void exe() {

		receiver.action();
	}

}

class Receiver {
	public void action() {
		System.out.println("command received!");
	}
}

class Invoker {
	private Command command;

	public Invoker(Command command) {
		super();
		this.command = command;
	}

	public void action() {
		command.exe();
	}
}

public class CommandTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Receiver receiver=new Receiver();
		Command cmd=new MyCommand(receiver);
		Invoker invoker=new Invoker(cmd);
		invoker.action();
	}
}
