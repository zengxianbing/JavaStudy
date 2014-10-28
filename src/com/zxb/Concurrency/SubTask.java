package com.zxb.Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SubTask extends Thread {
	   private String name; 
       private CyclicBarrier cb; 

       SubTask(String name, CyclicBarrier cb) { 
               this.name = name; 
               this.cb = cb; 
       } 

       public void run() { 
               System.out.println("[子任务" + name + "]开始执行了！"); 
               for (int i = 0; i < 999999; i++) ;    //模拟耗时的任务 
               System.out.println("[子任务" + name + "]开始执行完成了，并通知障碍器已经完成！"); 
               try { 
                       //通知障碍器已经完成 
                       cb.await(); 
               } catch (InterruptedException e) { 
                       e.printStackTrace(); 
               } catch (BrokenBarrierException e) { 
                       e.printStackTrace(); 
               } 
       } 
}
