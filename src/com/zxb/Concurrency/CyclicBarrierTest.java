package com.zxb.Concurrency;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) { 
        //创建障碍器，并设置MainTask为所有定数量的线程都达到障碍点时候所要执行的任务(Runnable) 
        CyclicBarrier cb = new CyclicBarrier(7, new MainTask()); 
        new SubTask("A", cb).start(); 
        new SubTask("B", cb).start(); 
        new SubTask("C", cb).start(); 
        new SubTask("D", cb).start(); 
        new SubTask("E", cb).start(); 
        new SubTask("F", cb).start(); 
        new SubTask("G", cb).start(); 
} 
}
