package leapstream.scoreboard.alien.ui.gunge.thread;

// FIX 377 Replace with AsynchronousLayer.
public interface ThreadUtil {
    void run(Runnable runnable);
    void daemon(Runnable runnable);
}
