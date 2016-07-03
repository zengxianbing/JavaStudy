package com.zxb.timer;

import java.util.Date;
import java.util.Random;
import java.util.TimerTask;

/**
 * Created by cengxianbing on 2015/12/15.
 */
public class TimerTask1 extends TimerTask {
    @Override
    public void run() {

        String base="test";
        Random random = new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));

        }
        System.out.println(new Date()+" ,"+sb.toString());

    }
}
