package leapstream.scoreboard.alien.resilient;

// FIX AQUEDUCT Push to boost.
public interface ResilientRunnables {
    Runnable imbune(Runnable runnable, ErrorHandler errors, TimeoutHandler timeouts, int timeout);
}
