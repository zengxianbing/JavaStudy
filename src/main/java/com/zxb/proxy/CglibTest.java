package com.zxb.proxy;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/11.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class CglibTest {
    public static void main(String[] args) {
        CglibProxy proxy=new CglibProxy();
        SayHello proxyImpl = (SayHello) proxy.getProxy(SayHello.class);
        proxyImpl.say();
    }
}
