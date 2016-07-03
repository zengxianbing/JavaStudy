package com.zxb.Concurrency.Phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/4/19.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class PhaserTest1
{
    public static void main(String[] args) {
        Phaser phaser=new Phaser( 1);
        for (int i = 0; i < 3; i++) {
            new MyThread((char)(97+i),phaser).start();



        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phaser.arrive();
    }
}

class MyThread extends Thread {
    private char c;

    private Phaser phaser;

    public MyThread(char c, Phaser phaser) {
        this.c = c;
        this.phaser = phaser;
    }

    @Override
    public void run() {

        phaser.awaitAdvance(phaser.getPhase());

        for (int i = 0; i < 100; i++) {
            System.out.println(c+" ");
            if (i % 1 == 0) {
                System.out.println();
            }
        }


    }
}
