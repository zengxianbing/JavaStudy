package com.zxb.Concurrency.cnblogs1;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest1 {

	private static List<String> list = new CopyOnWriteArrayList<String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MyThread("ta").start();
		new MyThread("tb").start();
	}

	private static class MyThread extends Thread {

		MyThread(String name) {
			super(name);
		}

		public void run() {
			int i = 0;
			while (i++ < 6) {
				// “线程名” + "-" + "序号"
				String val = Thread.currentThread().getName() + "-" + i;
				list.add(val);
				printAll();
			}
		}

	}

	private static void printAll() {
		String value = null;
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			value = (String) iter.next();
			System.out.print(value + ",");
		}
		System.out.println();
	}

}
