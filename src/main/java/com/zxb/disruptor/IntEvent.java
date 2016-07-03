package com.zxb.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/6.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class IntEvent {
    private int value=1;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
    public static EventFactory<IntEvent>  INT_ENEVT_FACTORY=new EventFactory<IntEvent>() {
        @Override
        public IntEvent newInstance() {
            return new IntEvent();
        }
    };
}
