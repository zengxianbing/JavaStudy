package com.suggest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Runner implements Callable<Integer> {

	private CountDownLatch begin;
	private CountDownLatch end;

	public Runner(CountDownLatch begin, CountDownLatch end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {

		int score = new Random().nextInt(25);
		begin.await();
		TimeUnit.MILLISECONDS.sleep(score);
		end.countDown();

		return score;
	}

}

public class CountDownLatchTest {

	public static void main(String[] args) throws Exception {

		int num = 10;
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(num);

		ExecutorService es = Executors.newFixedThreadPool(num);

		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		for (int i = 0; i < num; i++) {
			futures.add(es.submit(new Runner(begin, end)));
		}

		begin.countDown();
		end.await();

		int count = 0;

		for (Future<Integer> future : futures) {
			count += future.get();
		}

		System.out.println(count / num);

	}

}
