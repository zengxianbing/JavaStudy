package com.iteye.designpatterns.factory;

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

class SendFactory {
	public Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确的类型!");
			return null;
		}
	}
}

public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("sms");
		sender.Send();
	}

}

class SendFactory1 {
	public Sender produceMail() {
		return new MailSender();
	}

	public Sender produceSms() {
		return new SmsSender();
	}
}

class FactoryTest1 {
	public static void main(String[] args) {
		SendFactory1 factory = new SendFactory1();
		Sender sender = factory.produceMail();
		sender.Send();
	}
}

class SendFactory2 {
	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}
}

class FactoryTest2 {
	public static void main(String[] args) {
		Sender sender = SendFactory2.produceMail();
		sender.Send();
	}
}
