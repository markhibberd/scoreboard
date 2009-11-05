package leapstream.scoreboard.core.poll;

import leapstream.scoreboard.alien.aqueduct.ConduitIn;
import leapstream.scoreboard.alien.aqueduct.Job;

public class Poll implements Runnable {
    private Job job;
    ConduitIn in;

    public Poll(Job job) {
        this.job = job;
    }

    public void run() {
        in.add(job);
    }
}
