package com.zxb.guava.concurrent;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import junit.framework.TestCase;

import java.util.List;
import java.util.concurrent.Executor;

import static com.google.common.truth.Truth.assertThat;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2015/12/30.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class AbstractIdleServiceTest extends TestCase {

    public static class FunctionalTest extends TestCase {


        private static class DefaultService extends AbstractIdleService {

            @Override
            protected void startUp() throws Exception {

            }

            @Override
            protected void shutDown() throws Exception {

            }
        }

        public void testServiceStartStop() {
            AbstractIdleService service = new DefaultService();
            service.startAsync().awaitTerminated();
            assertEquals(Service.State.RUNNING, service.state());
            service.stopAsync().awaitTerminated();
            assertEquals(Service.State.TERMINATED, service.state());

        }

        public void testStart_failed() {
            final Exception exception = new Exception();
            AbstractIdleService service = new DefaultService() {
                @Override
                protected void startUp() throws Exception {
                    throw exception;
                }
            };
            try {
                service.startAsync().awaitRunning();
                fail();
            } catch (Exception e) {
                assertSame(exception, e.getCause());
            }
            assertEquals(Service.State.FAILED, service.state());


        }


        public void testStop_failed() {
            final Exception exception = new Exception("deliberate");
            AbstractIdleService service=new DefaultService(){
                @Override
                protected void shutDown() throws Exception {
                    throw exception;
                }
            };

            service.startAsync().awaitRunning();
            try {
                service.stopAsync().awaitTerminated();
                fail();
            } catch (Exception e) {
                assertSame(exception,e.getCause());
            }
            assertEquals(Service.State.FAILED,service.state());
        }
        
        public void testStart() {
            TestService service=new TestService();
            assertEquals(0, service.startUpCalled);
            service.startAsync().awaitRunning();
            assertEquals(1, service.startUpCalled);
            assertEquals(Service.State.RUNNING, service.state());

//            ASSERT.that(blah.isSomeBooleanValue()).isTrue();


            assertThat(service.transitionStates).containsExactly(Service.State.STARTING);
        }
    }

    private static class TestService extends AbstractIdleService {

        int startUpCalled = 0;
        int shutDownCalled = 0;
        final List<State> transitionStates = Lists.newArrayList();

        protected void startUp() throws Exception {
            assertEquals(0, startUpCalled);
            assertEquals(0, shutDownCalled);
            startUpCalled++;
            assertEquals(State.STARTING, state());

        }

        @Override
        protected void shutDown() throws Exception {
            assertEquals(1, startUpCalled);
            assertEquals(0, shutDownCalled);
            startUpCalled++;
            assertEquals(State.STOPPING, state());

        }

        @Override
        protected Executor executor() {

            transitionStates.add(state());
            return MoreExecutors.sameThreadExecutor();
        }
    }

}
