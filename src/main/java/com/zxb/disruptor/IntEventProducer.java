package com.zxb.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/6.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class IntEventProducer implements WorkHandler<IntEvent> {
    private int seq = 0;
    @Override
    public void onEvent(IntEvent intEvent) throws Exception {

        System.out.println("produced:"+seq);
        intEvent.setValue(++seq);
    }
}
