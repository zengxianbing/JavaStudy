package com.zxb.disruptor;

import com.lmax.disruptor.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/6.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class DisruptorTest {
    public static void main(String[] args) throws InterruptedException {
        //创建一个RingBuffer对象
        RingBuffer<IntEvent> ringBuffer = new RingBuffer<IntEvent>(IntEvent.INT_ENEVT_FACTORY,
                new SingleThreadedClaimStrategy(16),
                new SleepingWaitStrategy());

        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
        IntEventProcessor[] producers = new IntEventProcessor[1];
        for (int i = 0; i < producers.length; i++) {
            producers[i] = new IntEventProcessor();

        }

        WorkerPool<IntEvent> crawler = new WorkerPool<IntEvent>(ringBuffer,
                sequenceBarrier,
                new IntEventExceptionHandler(),
                producers);

        SequenceBarrier sb = ringBuffer.newBarrier(crawler.getWorkerSequences());
        IntEventProcessor[] processors = new IntEventProcessor[1];
        for (int i = 0; i < processors.length; i++) {
            processors[i] = new IntEventProcessor();

        }

        WorkerPool<IntEvent> applier = new WorkerPool<IntEvent>(ringBuffer, sb,
                new IntEventExceptionHandler(),
                processors);
        List<Sequence> gatingSequences = new ArrayList<Sequence>();
        for (Sequence s : crawler.getWorkerSequences()) {
            gatingSequences.add(s);
        }

        for (Sequence s : applier.getWorkerSequences()) {
            gatingSequences.add(s);
        }

        ringBuffer.setGatingSequences(gatingSequences.toArray(new Sequence[gatingSequences.size()]));

        ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 7, 10, TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(5));

        crawler.start(executor);
        applier.start(executor);
        while (true) {

            Thread.sleep(1000);
            long lastSeq = ringBuffer.next();
            ringBuffer.publish(lastSeq);
        }
    }
}

class IntEventExceptionHandler implements ExceptionHandler {

    @Override
    public void handleEventException(Throwable throwable, long l, Object o) {

    }

    @Override
    public void handleOnStartException(Throwable throwable) {

    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {

    }
}
