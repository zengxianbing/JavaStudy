package com.zxb.Concurrency.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/6/3.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class AtomicLongTest {

    public static void main(String[] args) {

        AtomicLong mAtoLong = new AtomicLong();

        mAtoLong.set(0x0123456789ABCDEFL);
        System.out.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
        System.out.printf("%20s : 0x%016X\n", "intValue()", mAtoLong.intValue());
        System.out.printf("%20s : 0x%016X\n", "longValue()", mAtoLong.longValue());
        System.out.printf("%20s : %s\n", "doubleValue()", mAtoLong.doubleValue());
        System.out.printf("%20s : %s\n", "floatValue()", mAtoLong.floatValue());

        System.out.printf("%20s : 0x%016X\n", "getAndDecrement()", mAtoLong.getAndDecrement());
        System.out.printf("%20s : 0x%016X\n", "decrementAndGet()", mAtoLong.decrementAndGet());
        System.out.printf("%20s : 0x%016X\n", "getAndIncrement()", mAtoLong.getAndIncrement());
        System.out.printf("%20s : 0x%016X\n", "incrementAndGet()", mAtoLong.incrementAndGet());

        System.out.printf("%20s : 0x%016X\n", "addAndGet(0x10)", mAtoLong.addAndGet(0x10));
        System.out.printf("%20s : 0x%016X\n", "getAndAdd(0x10)", mAtoLong.getAndAdd(0x10));

        System.out.printf("\n%20s : 0x%016X\n", "get()", mAtoLong.get());

        System.out.printf("%20s : %s\n", "compareAndSet()", mAtoLong.compareAndSet(0x12345679L, 0xFEDCBA9876543210L));
        System.out.printf("%20s : 0x%016X\n", "get()", mAtoLong.get());
    }
}
