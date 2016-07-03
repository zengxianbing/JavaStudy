package com.suggest;

public class TCPServer implements Runnable {

	public TCPServer() {
		Thread t = new Thread(this);
		t.setUncaughtExceptionHandler(new TCPServerExceptionHandler());
		t.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("系统正常运行" + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 抛出异常
			throw new RuntimeException();
		}
	}

	// 异常处理器
	private static class TCPServerExceptionHandler implements
			Thread.UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {

			System.out.println("线程" + t.getName() + "出现异常，自行启动，请检查原因");
			e.printStackTrace();
			new TCPServer();

		}

	}


}
