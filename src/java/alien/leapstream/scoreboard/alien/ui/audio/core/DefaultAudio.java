package leapstream.scoreboard.alien.ui.audio.core;

import java.util.concurrent.BlockingQueue;

public class DefaultAudio implements Audio {
    private BlockingQueue<Playable> q;

    public DefaultAudio(BlockingQueue<Playable> q) {
        this.q = q;
    }

    public void play(Playable playable) {
        q.add(playable);
    }
}
