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
public class Consume implements Runnable {
    private List container=null;
    private int count;

    public Consume(List container) {
        this.container = container;
    }

    @Override
    public void run() {


        while (true){
            synchronized (container){
                if(container.size()==0){
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                container.remove(0);
                container.notify();
                System.out.println("我吃了"+(++count)+"个");
            }
        }




















    }
}
