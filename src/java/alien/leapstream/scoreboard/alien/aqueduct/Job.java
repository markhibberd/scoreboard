package leapstream.scoreboard.alien.aqueduct;

public interface Job {
    Runnable runner();
    TimeoutHandler timer();
}
