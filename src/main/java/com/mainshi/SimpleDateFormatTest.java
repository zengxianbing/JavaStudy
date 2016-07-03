package com.mainshi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Date date1 = new Date();
		Date date2 = new Date(date1.getTime() + 1000 * 24 * 60 * 60);
		System.out.println("date1=" + date1);
		System.out.println("date2=" + date2);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SDFThread1 s1 = new SDFThread1(sdf, date1);
		SDFThread2 s2 = new SDFThread2(sdf, date2);
		new Thread(s1).start();
		new Thread(s2).start();

	}

}

class SDFThread1 implements Runnable {

	private SimpleDateFormat sdf;
	private Date date;

	public SDFThread1(SimpleDateFormat sdf, Date date) {
		super();
		this.sdf = sdf;
		this.date = date;
	}

	@Override
	public void run() {

		while (true) {
			String strDate = sdf.format(date);
			System.out.println("thread1:" + strDate);
			if ("2014-09-07".equals(strDate)) {
				System.out.println("Error:" + strDate);
				System.exit(0);
			}
		}
	}

}

class SDFThread2 implements Runnable {

	private SimpleDateFormat sdf;
	private Date date;

	public SDFThread2(SimpleDateFormat sdf, Date date) {
		super();
		this.sdf = sdf;
		this.date = date;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			String strDate = sdf.format(date);
			System.out.println("thread2:" + strDate);
			if ("2014-05-04".equals(strDate)) {
				System.out.println("Error:date1" + strDate);
				System.exit(0);
			}
		}
	}

}
