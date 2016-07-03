package com.zxb.Concurrency.object;

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
public class Product implements Runnable {
    private List container=null;
    private int count;

    public Product(List container) {
        this.container = container;
    }

    @Override
    public void run() {

        while (true){
            synchronized (container){
                try {
                    container.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                container.add(new Object());
                container.notify();
                System.out.println("我生产了"+(++count)+"个");
            }
        }

















    }
}
