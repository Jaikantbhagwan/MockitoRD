

package threadtest;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


/**
 * <p>This executor guarantees that there is never more than one element waiting to be executed. If an element is
 * submitted for execution and another element is still in queue, the newly submitted element replaces the previously
 * queued element in the queue</p>
 *
 * <p>Additionally this executor sleeps a constructor specified number of milliseconds before executing tasks to give queued
 * items a chance to be canceled</p>
 *
 * <p>This class is intended to be used when runnables are created in rapid succession and newer runnables supersede
 * ones that have been created previously. This is e.g. the case if a user interface reacts to user inputs, possibly
 * on every keystroke and the reaction causes slow tasks (e.g. server calls for validation).</p>
 */
public class SingleQueuedElementExecutor implements Executor {
    private final Sleeper sleeper;
    private final ExecutorService delegate;
    private Future<?> queuedSleeper;
    private Future<?> queuedElement;

    public SingleQueuedElementExecutor(final ExecutorService delegate, final long sleepBeforeExecutionMilliseconds) {
        this.delegate = delegate;
        sleeper = new Sleeper(sleepBeforeExecutionMilliseconds);
    }

    public void execute(final Runnable runnable) {
        if (queuedElement != null) {
            queuedElement.cancel(false);
            queuedSleeper.cancel(true);
        }
        queuedSleeper = delegate.submit(sleeper);
        queuedElement = delegate.submit(runnable);
    }

    private static class Sleeper implements Runnable {
        private final long duration;

        private Sleeper(final long duration) {
            this.duration = duration;
        }

        public void run() {
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                // Simply abort sleeping
            }
        }
    }
}
