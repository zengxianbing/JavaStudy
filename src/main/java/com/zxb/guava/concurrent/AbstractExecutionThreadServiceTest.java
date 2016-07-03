package com.zxb.guava.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2015/12/30.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class AbstractExecutionThreadServiceTest extends AbstractExecutionThreadService {

    private volatile boolean running = true;

    @Override
    protected void startUp() throws Exception {

//        super.startUp();
    }

    @Override
    protected void shutDown() throws Exception {
//        super.shutDown();
    }

    @Override
    protected void triggerShutdown() {
//        super.triggerShutdown();

        running = false;
    }

    @Override
    protected void run() throws Exception {

        while (running) {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            System.out.println("do our work....");
        }
    }

    public static void main(String[] args) throws InterruptedException {


        AbstractExecutionThreadServiceTest service = new AbstractExecutionThreadServiceTest();
        service.addListener(new Listener() {
            @Override
            public void starting() {
//                super.starting();
                System.out.println("服务开始启动....");
            }

            @Override
            public void running() {
//                super.running();
                System.out.println("服务开始运行....");

            }

            @Override
            public void stopping(State from) {
//                super.stopping(from);
                System.out.println("服务开始关闭中....");

            }

            @Override
            public void terminated(State from) {
//                super.terminated(from);
                System.out.println("服务终止....");

            }

            @Override
            public void failed(State from, Throwable failure) {
//                super.failed(from, failure);
                System.out.println("服务开始失败....");

            }
        }, MoreExecutors.sameThreadExecutor());

        service.startAsync().awaitRunning();
        System.out.println("服务状态为：" + service.state());
        Thread.sleep(10);
        service.stopAsync().awaitTerminated();
        System.out.println("服务状态为：" + service.state());

    }
}
