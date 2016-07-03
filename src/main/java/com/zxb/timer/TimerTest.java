package com.zxb.timer;
import org.junit.Test;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by cengxianbing on 2015/12/15.
 */
public class TimerTest {

    @Test
    public  void testTimer() throws InterruptedException {

        Timer timer=new Timer();
        timer.schedule(new TimerTask1(),1);
        timer.schedule(new TimerLongTask(),1);
        timer.schedule(new TimerTask1(),1);
        TimeUnit.SECONDS.sleep(20);
        timer.cancel();

    }
}
