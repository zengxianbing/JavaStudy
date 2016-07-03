package com.zxb.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicLongTest {
	  public static void main(String[] args) { 
          ExecutorService pool = Executors.newFixedThreadPool(2); 
          Runnable t1 = new MyRunnable("张三", 2000); 
          Runnable t2 = new MyRunnable("李四", 3600); 
          Runnable t3 = new MyRunnable("王五", 2700); 
          Runnable t4 = new MyRunnable("老张", 600); 
          Runnable t5 = new MyRunnable("老牛", 1300); 
          Runnable t6 = new MyRunnable("胖子", 800); 
          //执行各个线程 
          pool.execute(t1); 
          pool.execute(t2); 
          pool.execute(t3); 
          pool.execute(t4); 
          pool.execute(t5); 
          pool.execute(t6); 
          //关闭线程池 
          pool.shutdown(); 
  } 
}
