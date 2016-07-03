package com.iteye.designpatterns.abstractfactory;

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

interface Provider {
	public Sender produce();
}

class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new MailSender();
	}

}

class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}

public class AbstractFactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();

	}

}
