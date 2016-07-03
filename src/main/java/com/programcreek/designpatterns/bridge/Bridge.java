package com.programcreek.designpatterns.bridge;

interface ITV {
	public void on();

	public void off();

	public void switchChannel(int channel);

}

class SamsungTV implements ITV {

	@Override
	public void on() {
		System.out.println("Samsung is turned on.");
	}

	@Override
	public void off() {
		System.out.println("Samsung is turned off.");
	}

	@Override
	public void switchChannel(int channel) {
		System.out.println("Samsung: channel - " + channel);
	}

}

class SonyTV implements ITV {

	@Override
	public void on() {
		System.out.println("Sony is turned on.");
	}

	@Override
	public void off() {
		System.out.println("Sony is turned off.");
	}

	@Override
	public void switchChannel(int channel) {
		System.out.println("Sony: channel - " + channel);
	}

}

abstract class AbstractRemoteControll {

	private ITV tv;

	public AbstractRemoteControll(ITV tv) {
		super();
		this.tv = tv;
	}

	public void turnOn() {
		tv.on();
	}

	public void turnOff() {
		tv.off();
	}

	public void setChannel(int channel) {
		tv.switchChannel(channel);
	}

}

class LogitechRemoteControl extends AbstractRemoteControll {

	public LogitechRemoteControl(ITV tv) {
		super(tv);
		// TODO Auto-generated constructor stub
	}

	public void setChannelKeyboard(int channel) {
		setChannel(channel);
		System.out.println("Logitech use keyword to set channel.");
	}
}

public class Bridge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ITV tv = new SonyTV();
		LogitechRemoteControl lrc = new LogitechRemoteControl(tv);
		lrc.setChannelKeyboard(100);

	}

}
