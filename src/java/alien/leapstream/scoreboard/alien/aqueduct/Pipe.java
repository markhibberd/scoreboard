package leapstream.scoreboard.alien.aqueduct;

import leapstream.scoreboard.edge.java.lang.Thread;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;

public class Pipe implements Runnable {
    private Job job;
    Timeout timeout;
    Weaken weaken;
    Nu nu;

    public Pipe(Job job) {
        this.job = job;
    }

    public void run() {
        Runnable runnable = job.runner();
        Thread thread = nu.nu(Thread.class, runnable);
        thread.setDaemon(true);
        thread.start();
        safe(thread);
    }

    private void safe(Thread thread) {
        Long time = weaken.w(timeout);
        try {
            thread.join(time);
        } catch (RuntimeException e) {
            TimeoutHandler handler = job.timer();
            handler.timeout();
        }
    }
}
