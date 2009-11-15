package leapstream.scoreboard.core.poll;

// FIX AQUEDUCT Push close to aqueduct. 
public interface Poller {
    void poll(Runnable r, int period);
}
