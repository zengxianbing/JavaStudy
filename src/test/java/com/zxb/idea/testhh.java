package com.zxb.idea;

/**
 * Title: <br>
 * <p>
 * Description: <br>
 * <p>
 * Created by zengxianbing on 2016/6/17.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class testhh {

    public static void main(String[] args) {

        new testThread().start();
        new testThread().start();
    }
}

class testThread extends Thread {
   private  static   int sum=0;
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            sum++;
        }
        System.out.println("sum="+sum);
    }
}
