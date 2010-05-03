package leapstream.scoreboard.alien.ui.audio.core;

public class SequentialPlayable implements Playable {
    private Playable[] playables;

    public SequentialPlayable(Playable...  playables) {
        this.playables = playables;
    }

    public void play() {
        for (Playable playable : playables) {
            playable.play();
        }
    }
}
