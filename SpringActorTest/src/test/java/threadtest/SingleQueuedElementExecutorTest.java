

package threadtest;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;


public class SingleQueuedElementExecutorTest {

    private SingleQueuedElementExecutor executor;

    private ExecutorService delegateExecutor;
    private static final long SLEEP_BETWEEN_TASKS_MS = 10;
    private static final long NANO_TIME_ACCURACY_MS = 2;

    @Before
    public void setUp() throws Exception {
        delegateExecutor = Executors.newCachedThreadPool();
        executor = new SingleQueuedElementExecutor(delegateExecutor, SLEEP_BETWEEN_TASKS_MS);
    }

    @Test(timeout = 1000)
    public void testOnlyExecuteLastWhenTasksAreSubmittedInQuickSuccession() throws InterruptedException {
        final CountDownLatch lastExecuted = new CountDownLatch(1);
        final AtomicInteger executedCount = new AtomicInteger(0);
        for (int i = 0; i < 1000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    executedCount.incrementAndGet();
                }
            });
        }
        executor.execute(new Runnable() {
            @Override
            public void run() {
                lastExecuted.countDown();
            }
        });
        lastExecuted.await();
        // assertThat(executedCount.get()).isEqualTo(0); // all tasks preceding the last should have been cancelled
    }

    @Test(timeout = 1000)
    public void testSubmissionWhileExecutingPreviousDoesNotCancelPrevious() throws InterruptedException {
        final CountDownLatch startFirst = new CountDownLatch(1);
        final CountDownLatch secondSubmitted = new CountDownLatch(1);
        final CountDownLatch secondDone = new CountDownLatch(1);
        final AtomicBoolean firstExecuted = new AtomicBoolean(false);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                startFirst.countDown();
                try {
                    secondSubmitted.await();
                    firstExecuted.set(true);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        startFirst.await();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                secondDone.countDown();
            }
        });
        secondDone.await();
        // assertThat(firstExecuted.get()).isTrue();
    }

}
