package com.zxb.threads;

/**
 * Created by cengxianbing on 2015/11/2.
 */
public class TestThread
{
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>()
    {
        public Integer initialValue()
        {
            return 0;
        }
    };



    public  int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    public  static  void main(String[] artgs){
        TestThread sn=new TestThread();

        TestClient t1=new TestClient(sn);
        TestClient t2=new TestClient(sn);
        TestClient t3=new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private  static class TestClient extends  Thread{
        private  TestThread sn;
        public  TestClient(TestThread sn){
            this.sn=sn;
        }
        public void run(){
            for (int i=0;i<3;i++){
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                        + sn.getNextNum() + "]");
            }
        }
    }
}
