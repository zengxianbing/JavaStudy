package com.iteye.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;


interface Sender {
	public void Send();
}

class MailSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is mailsender!");
	}

}

class SmsSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is sms sender!");
	}

}

class Builder {
	private List<Sender> list = new ArrayList<Sender>();

	public void produceMailSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
	}

	public void produceSmsSender(int count) {
		for (int i = 0; i < count; i++) {
			list.add(new SmsSender());
		}
	}

}

public class BuilderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Builder builder = new Builder();
		builder.produceMailSender(10);
	}

}
