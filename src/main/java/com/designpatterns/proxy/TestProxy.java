package com.designpatterns.proxy;

/**
 * Created by cengxianbing on 2015/12/12.
 */
public class TestProxy {
    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookFacade = (BookFacade) proxy.bing(new BookFacadeImpl());
        bookFacade.addBook();
    }
}
