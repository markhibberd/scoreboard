package leapstream.scoreboard.alien.collections;

import java.util.concurrent.BlockingQueue;

public class DefaultQueues implements Queues {
    public <T> T blockingTake(BlockingQueue<T> q) {
        try {
            return q.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
