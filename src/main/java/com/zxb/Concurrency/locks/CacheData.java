package com.zxb.Concurrency.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/6.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class CacheData {
    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rw1=new ReentrantReadWriteLock();
    void processCacheData() {
        rw1.readLock().lock();
        if (!cacheValid) {
            rw1.readLock().unlock();
            rw1.writeLock().lock();
            try {
                if (!cacheValid) {
                    data = "...";
                    cacheValid = true;
                }
                rw1.readLock().lock();
            } finally {

                rw1.writeLock().unlock();
            }
        }

        try {
//            use(data);
        } finally {
            rw1.readLock().unlock();
        }
    }
}
