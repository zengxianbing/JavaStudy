package com.designpatterns.proxy;

/**
 * Created by cengxianbing on 2015/12/12.
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        BookFacadeProxyCglib cglib = new BookFacadeProxyCglib();
        BookFacadeImpl bookCglib = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
        bookCglib.addBook();
    }
}
