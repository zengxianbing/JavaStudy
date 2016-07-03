package com.zxb.timer;
import org.junit.Test;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by cengxianbing on 2015/12/15.
 */
public class ScheduledThreadPoolExecutorTest {
    @Test
    public void testScheduledThreadPoolExecutor() {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException();
            }
        }, 1000, 5000, TimeUnit.MICROSECONDS);

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.nanoTime());
            }
        },1000,2000, TimeUnit.MICROSECONDS);
    }
}
