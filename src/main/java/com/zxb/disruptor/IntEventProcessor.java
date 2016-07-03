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
public class IntEventProcessor implements WorkHandler<IntEvent> {
    @Override
    public void onEvent(IntEvent intEvent) throws Exception {
        System.out.println(intEvent.getValue());
        intEvent.setValue(1);
    }
}
