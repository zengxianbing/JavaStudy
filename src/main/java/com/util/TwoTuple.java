package com.util;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/5/27.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class TwoTuple<K,V> {
    private final K first;

    private final V second;

    public TwoTuple(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "first = " + first + ",second = " + second;
    }
}
