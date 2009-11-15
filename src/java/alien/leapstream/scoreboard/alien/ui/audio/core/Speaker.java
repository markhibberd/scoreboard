package leapstream.scoreboard.alien.ui.audio.core;

import leapstream.scoreboard.alien.collections.Queues;

import java.util.concurrent.BlockingQueue;

public class Speaker implements Runnable {
    private BlockingQueue<Playable> q;
    Queues queues;

    public Speaker(BlockingQueue<Playable> q) {
        this.q = q;
    }

    public void run() {
        for (;;) {
            play();
        }
    }

    private void play() {
        Playable playable = queues.blockingTake(q);
        playable.play();
    }

}
