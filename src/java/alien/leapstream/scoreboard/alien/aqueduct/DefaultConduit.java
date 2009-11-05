package leapstream.scoreboard.alien.aqueduct;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DefaultConduit implements Conduit {
    private final BlockingQueue<Job> q = new LinkedBlockingQueue<Job>();
    
    public void add(Job job) {
        q.add(job);
    }

    public Job take() {
        try {
            return q.take();
        // FIX AQUEDUCT edge? maybe need to handle this a bit better
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
