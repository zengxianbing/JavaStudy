package com.zxb.guava.concurrent;

import junit.framework.TestCase;

import static com.google.common.util.concurrent.Service.State.*;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2015/12/30.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class ServiceTest extends TestCase {

    public void testStateOrdering() {
        assertLessThan(NEW, STARTING);
        assertLessThan(NEW, TERMINATED);
        assertLessThan(STARTING, RUNNING);
        assertLessThan(STARTING, STOPPING);
        assertLessThan(STARTING, FAILED);
        assertLessThan(RUNNING, STOPPING);
        assertLessThan(RUNNING, FAILED);
        assertLessThan(STOPPING, FAILED);
        assertLessThan(STOPPING, TERMINATED);
    }

    private static <T extends Comparable<? super T>> void assertLessThan(T a, T b) {
        if (a.compareTo(b) >= 0) {
            fail(String.format("Expected %s to be less than %s", a, b));
        }
    }
}
