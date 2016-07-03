package com.suggest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {

		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Integer> future = es.submit(new TaxCalculator(100));

		while (!future.isDone()) {
			TimeUnit.MILLISECONDS.sleep(200);
			System.out.print("#");
		}

		System.out.println(future.get());

		es.shutdown();

	}

}
