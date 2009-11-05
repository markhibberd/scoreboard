package leapstream.scoreboard.alien.aqueduct;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DefaultConduit implements Conduit {
    private final BlockingQueue<Runnable> q = new LinkedBlockingQueue<Runnable>();

    public void add(Runnable runnable) {
        q.add(runnable);
    }

    public Runnable take() {
        try {
            return q.take();
        // FIX AQUEDUCT edge? maybe need to handle this a bit better
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
