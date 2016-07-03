package com.zxb.Concurrency.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/4/19.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class Car  implements Runnable {

    private final Semaphore parkingSlot;

    private int carNo;

    public Car(int carNo, Semaphore parkingSlot) {
        this.carNo = carNo;
        this.parkingSlot = parkingSlot;
    }

    @Override
    public void run() {

        try {
            parkingSlot.acquire();
            parking();
            sleep(300);
            parkingSlot.release();
            leaving();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void parking() {
        System.out.println(String.format("%d号车泊车", carNo));
    }

    private void leaving() {
        System.out.println(String.format("%d号车离开车位", carNo));
    }


    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
