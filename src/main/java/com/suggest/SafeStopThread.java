package com.suggest;

public class SafeStopThread extends Thread {

	private volatile boolean stop = false;

	public void run() {
		while (stop) {
			// Do Something
		}
	}

	public void terminate() {
		stop = true;
	}

}
