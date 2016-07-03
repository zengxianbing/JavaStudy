package com.designpatterns.proxy;

/**
 * Created by cengxianbing on 2015/12/12.
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加图书的方法。。。。");
    }
}
