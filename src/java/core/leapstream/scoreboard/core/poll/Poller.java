package leapstream.scoreboard.core.poll;

public interface Poller {
    void poll(Runnable r, int period);
}
