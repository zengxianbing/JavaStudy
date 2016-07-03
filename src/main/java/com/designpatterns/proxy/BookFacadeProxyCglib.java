package com.designpatterns.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by cengxianbing on 2015/12/12.
 */
public class BookFacadeProxyCglib implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object object) {
        this.target = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object object;
        System.out.println("事务开始");
        object = methodProxy.invokeSuper(o, objects);
        System.out.println("事务结束");


        return object;
    }
}
