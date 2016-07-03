package com.zxb.timer;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by cengxianbing on 2015/12/15.
 */
public class TimerLongTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("TimerLongTask:开始沉睡");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TimerLongTask:已结醒来");

    }
}
