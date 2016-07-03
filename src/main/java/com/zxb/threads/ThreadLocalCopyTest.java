package com.zxb.threads;

/**
 * Created by cengxianbing on 2015/11/2.
 */
public class ThreadLocalCopyTest
{
    ThreadLocalCopy<Integer> tlNum;
    {
        tlNum = new ThreadLocalCopy<Integer>()
        {
            protected Integer initialValue()
            {
                return 0;
            }
        };
    }

    public  int getNextNum(){
        Integer num=tlNum.get();
        tlNum.set(num+1);
        return num;
    }
    private  static  class TestThread implements Runnable{
        private ThreadLocalCopyTest tlt;
        public TestThread(ThreadLocalCopyTest tlt){
            this.tlt=tlt;
        }

        @Override
        public void run()
        {
            int n=3;
            for(int i=0;i<n;i++){
               System.out.println("线程【"+Thread.currentThread().getName()
               +"】    【"+tlt.getNextNum()+"】");
            }

        }
    }


    public static void main(String[] args){
        ThreadLocalCopyTest tlt=new ThreadLocalCopyTest();
      TestThread tt1=new TestThread(tlt);
       TestThread tt2=new TestThread(tlt);
       TestThread tt3=new TestThread(tlt);

        Thread t1=new Thread(tt1);
        Thread t2=new Thread(tt2);
        Thread t3=new Thread(tt3);

        t1.start();
        t2.start();
        t3.start();
    }
}
