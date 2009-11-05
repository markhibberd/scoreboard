package leapstream.scoreboard.alien.resilient;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.edge.java.lang.Thread;

public class TimeBoxedRunnable implements Runnable {
    private TimeoutHandler handler;
    private Runnable delegate;
    private int timeout;
    Nu nu;
    
    public TimeBoxedRunnable(Runnable delegate, TimeoutHandler handler, int timeout) {
        this.delegate = delegate;
        this.handler = handler;
        this.timeout = timeout;
    }

    public void run() {
        Thread thread = nu.nu(Thread.class, delegate);
        thread.setDaemon(true);
        thread.start();
        safe(thread);
    }

    private void safe(Thread thread) {
        try {
            thread.join(timeout);
        } catch (RuntimeException e) {
            handler.timeout();
        }
    }
}

