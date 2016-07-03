package com.zxb.Concurrency.object;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2015/12/16.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class WaitNotifyTest {
    @Test
    public void testWaitNotify1() {
        final Object lock = new Object();

        Thread thread1 = new Thread(new OutputThread(1, lock));
        Thread thread2 = new Thread(new OutputThread(2, lock));

        thread1.start();
        thread2.start();
    }
    @Test
    public void testWaitNotifyMultiThread() {
        List container = new ArrayList(5);

        new Thread(new Consume(container)).start();
        new Thread(new Product(container)).start();
        new Thread(new Consume(container)).start();
        new Thread(new Product(container)).start();
    }

}



