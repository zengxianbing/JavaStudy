package com.zxb.Concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
public class ParkingCars {

    private static final int NUMBER_OF_CARS = 30;

    private static final int NUMBER_OF_PARKING_SLOT = 10;

    public static void main(String[] args) {
        Semaphore parkingSlot=new Semaphore(NUMBER_OF_PARKING_SLOT,true);

        ExecutorService service = Executors.newCachedThreadPool();

        for (int carNo = 0; carNo < NUMBER_OF_CARS; carNo++) {

            service.execute(new Car(carNo,parkingSlot));
        }

        sleep(3000);

        service.shutdown();

        System.out.println(parkingSlot.availablePermits()+"  个停车位可以用！");
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
