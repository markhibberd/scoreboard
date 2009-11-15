package leapstream.scoreboard.alien.aqueduct;

import leapstream.scoreboard.alien.collections.Queues;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DefaultConduit implements Conduit {
    private final BlockingQueue<Runnable> q = new LinkedBlockingQueue<Runnable>();
    Queues queues;

    public void add(Runnable runnable) {
        q.add(runnable);
    }

    public Runnable take() {
        return queues.blockingTake(q);
    }
}
