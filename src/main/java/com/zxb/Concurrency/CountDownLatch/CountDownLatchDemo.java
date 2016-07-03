package com.zxb.Concurrency.CountDownLatch;

import junit.framework.TestCase;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by cengxianbing on 2015/11/10.
 */
public class CountDownLatchDemo extends TestCase
{

    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss\"");

    @Test
    public void testCountDownLatchDemo1() throws InterruptedException
    {
        CountDownLatch latch = new CountDownLatch(2);
        Worker worker1 = new Worker("zhang san", 5000, latch);
        Worker worker2 = new Worker("li si", 8000, latch);
        worker1.start();
        worker2.start();
        latch.await();
        System.out.println("all work done at" + sdf.format(new Date()));

    }

    static class Worker extends Thread
    {

        String workerName;

        @Override
        public void run()
        {

            System.out.println("Worker " + workerName + "  do work begin at " + sdf.format(new Date()));
            doWork();
            System.out.println("Worker " + workerName + "  do work complete at " + sdf.format(new Date()));
            latch.countDown();


        }

        int workTime;
        CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch)
        {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        private void doWork()
        {

            try
            {
                Thread.sleep(workTime);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
