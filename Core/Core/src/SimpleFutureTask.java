import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Minimal FutureTask-like implementation.
 * - Wraps a Callable<V>
 * - Starts execution on a dedicated Thread
 * - get() blocks until result available (or exception)
 * - supports cancel (best-effort, interrupts worker thread)
 */
public class SimpleFutureTask<V> implements Future<V> {
    private final Callable<V> callable;
    private volatile boolean cancelled = false;
    private volatile boolean done = false;
    private V result = null;
    private Exception exception = null;
    private final Thread runner;

    public SimpleFutureTask(Callable<V> callable) {
        this.callable = callable;
        this.runner = new Thread(this::runCallable);
        // start automatically; if you prefer manual start, remove this line and call start()
        this.runner.start();
    }

    private void runCallable() {
        try {
            if (cancelled) return;
            V r = callable.call();
            synchronized (this) {
                result = r;
                done = true;
                this.notifyAll();
            }
        } catch (Exception ex) {
            synchronized (this) {
                exception = ex;
                done = true;
                this.notifyAll();
            }
        }
    }

    /** Optional: allow manual start (if you removed auto-start in ctor) */
    public void start() {
        runner.start();
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        if (done || cancelled) return false;
        cancelled = true;
        if (mayInterruptIfRunning) runner.interrupt();
        synchronized (this) {
            // mark done so get() won't block forever
            done = true;
            this.notifyAll();
        }
        return true;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        synchronized (this) {
            while (!done && !cancelled) {
                this.wait();
            }
            if (cancelled) throw new ExecutionException(new IllegalStateException("Task was cancelled"));
            if (exception != null) throw new ExecutionException(exception);
            return result;
        }
    }

    @Override
    public V get(long timeout, TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        long millis = unit.toMillis(timeout);
        long end = System.currentTimeMillis() + millis;
        synchronized (this) {
            while (!done && !cancelled) {
                long now = System.currentTimeMillis();
                long remaining = end - now;
                if (remaining <= 0) throw new TimeoutException("Timeout waiting for task");
                this.wait(remaining);
            }
            if (cancelled) throw new ExecutionException(new IllegalStateException("Task was cancelled"));
            if (exception != null) throw new ExecutionException(exception);
            return result;
        }
    }

    // --- simple test/demo ---
    public static void main(String[] args) {
        Callable<String> job = () -> {
            Thread.sleep(2000);
            return "Hello from callable!";
        };

        SimpleFutureTask<String> future = new SimpleFutureTask<>(job);

        System.out.println("Waiting for result...");
        try {
            String value = future.get(); // blocks until job finishes
            System.out.println("Result: " + value);
        } catch (ExecutionException ee) {
            System.err.println("Callable threw: " + ee.getCause());
        } catch (InterruptedException ie) {
            System.err.println("Main thread interrupted");
        }
    }
}


/*
    Notes / behaviors:

    The constructor currently auto-starts the worker thread. If you prefer explicit control, remove this.runner.start() from the constructor and call start() manually.

    get() blocks until completion and translates exceptions thrown by the Callable into ExecutionException, matching java.util.concurrent.Future semantics.

    cancel(true) attempts to interrupt the running thread; cancellation is best-effort.

    The implementation is minimal and intended for learning/demonstration. The JDK FutureTask has more features (runnables, state transitions, listeners, atomic state updates), but this covers the core blocking get() behavior safely.

    Want me to extend this with run()-style constructor (Runnable + result), or add callback/listener support or better state transitions using AtomicInteger?
 */

