package com.zxb.idea;

import junit.framework.TestCase;
import org.junit.Test;

public class IdeaTestTest extends TestCase {

    @Test
    public void test1() {
        IdeaTest ideaTest = new IdeaTest();
        ideaTest.test1();
        int num = 0;
        test2();

        System.out.println("num" + num);
        num += 1;
        System.out.println("num" + num);

    }

    private void test2() {

        System.out.println("num");

        System.out.print("test");
        for (int i = 0; i < 10; i++) {
            System.out.println("idea test1");
        }
        System.out.println("idea sout");


    }

    @Test
    public void test3() {
        int i=4;
        if (i != 3 && i != 4) {
            System.out.println("不是3和4");
        } else {
            System.out.println("是3和4");

        }
    }

    @Test
    public void test4() {

        int b=0;
        new Thread(){


        };
    }


    public static void main(String[] args) {
        System.out.println("idea sout test");
    }
}