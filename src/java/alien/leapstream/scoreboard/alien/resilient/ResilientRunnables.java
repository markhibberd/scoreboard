package leapstream.scoreboard.alien.resilient;

import leapstream.scoreboard.alien.resilient.ErrorHandler;
import leapstream.scoreboard.alien.resilient.TimeoutHandler;

public interface ResilientRunnables {
    Runnable imbune(Runnable runnable, ErrorHandler errors, TimeoutHandler timeouts, int timeout);
}
