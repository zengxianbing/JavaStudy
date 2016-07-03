package com.zxb.Concurrency.atomic;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/6/3.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class LongArrayTest {
    public static void main(String[] args) {
        long[] arrLong = new long[]{10, 20, 30, 40, 50};

        AtomicLongArray ala = new AtomicLongArray(arrLong);

        ala.set(0, 100);

        for (int i = 0; i <ala.length() ; i++) {

            System.out.printf("get(%d) : %s\n", i, ala.get(i));
        }


        System.out.printf("%20s : %s\n", "getAndDecrement(0)", ala.getAndDecrement(0));
        System.out.printf("%20s : %s\n", "decrementAndGet(1)", ala.decrementAndGet(1));
        System.out.printf("%20s : %s\n", "getAndIncrement(2)", ala.getAndIncrement(2));
        System.out.printf("%20s : %s\n", "incrementAndGet(3)", ala.incrementAndGet(3));

        System.out.printf("%20s : %s\n", "addAndGet(100)", ala.addAndGet(0, 100));
        System.out.printf("%20s : %s\n", "getAndAdd(100)", ala.getAndAdd(1, 100));

        System.out.printf("%20s : %s\n", "compareAndSet()", ala.compareAndSet(2, 31, 1000));
        System.out.printf("%20s : %s\n", "get(2)", ala.get(2));
    }
}
