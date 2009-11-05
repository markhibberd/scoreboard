package leapstream.scoreboard.alien.aqueduct;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.LinkedBlockingQueue;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import au.net.netstorm.boost.bullet.incredibles.core.Weaken;

public class DefaultResivoir implements Resivoir, Constructable {
    private ThreadPoolExecutor executor;
    ConduitOut out;
    Weaken weaken;
    Pool pool;
    Impl impl;

    public void constructor() {
        Integer size = weaken.w(pool);
        // FIX AQUEDUCT stinky...
        executor = new ThreadPoolExecutor(2, size, 0,  TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new CallerRunsPolicy());
    }

    public int threads() {
        return executor.getMaximumPoolSize();
    }

    public void threads(int count) {
        executor.setMaximumPoolSize(count);
    }

    // FIX AQUEDUCT Stop?
    public void run() {
        for (;;) {
            Job job = out.take();
            Pipe pipe = impl.impl(Pipe.class, job);
            executor.execute(pipe);
        }
    }
}