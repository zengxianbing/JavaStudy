package com.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by cengxianbing on 2015/12/12.
 */
public class BookFacadeProxy implements InvocationHandler {
    private Object target;
    public Object bing(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("事务开始");
        result = method.invoke(target, args);
        System.out.println("事务结束");
        return result;
    }
}
