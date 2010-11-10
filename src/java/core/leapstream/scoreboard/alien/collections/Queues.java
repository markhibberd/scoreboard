package leapstream.scoreboard.alien.collections;

import java.util.concurrent.BlockingQueue;

public interface Queues {
    <T> T blockingTake(BlockingQueue<T> q);
}
