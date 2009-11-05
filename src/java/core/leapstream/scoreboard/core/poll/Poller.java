package leapstream.scoreboard.core.poll;

import leapstream.scoreboard.alien.aqueduct.Job;

public interface Poller {
    void poll(Job job, Long period);   
}
