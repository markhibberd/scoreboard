package leapstream.scoreboard.core.poll;

import leapstream.scoreboard.alien.aqueduct.ConduitIn;

public class Poll implements Runnable {
    private Runnable r;
    ConduitIn in;

    public Poll(Runnable r) {
        this.r = r;
    }

    public void run() {
        in.add(r);
    }
}
