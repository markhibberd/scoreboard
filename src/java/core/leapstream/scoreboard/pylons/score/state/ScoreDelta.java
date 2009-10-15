package leapstream.scoreboard.pylons.score.state;

public interface ScoreDelta {
    boolean hasChanged();
    boolean broke();
    boolean fixed();
}
