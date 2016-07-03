package com.zxb.threads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cengxianbing on 2015/11/2.
 */
public class ThreadLocalCopy<T>
{
    private Map<Thread, T> map = Collections.synchronizedMap(new HashMap<Thread, T>());


    public T get()
    {
        Thread currentThread = Thread.currentThread();
        T temp = map.get(currentThread);
        if (temp == null && map.containsKey(currentThread))
        {
            temp = initialValue();
            map.put(currentThread, temp);
        }
        return temp;
    }


    public void set(T value)
    {
        map.put(Thread.currentThread(), value);
    }

    public void remove()
    {
        map.remove(Thread.currentThread());
    }

    private T initialValue()
    {
        return null;
    }
}
