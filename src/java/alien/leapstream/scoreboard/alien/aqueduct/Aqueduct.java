package leapstream.scoreboard.alien.aqueduct;

public interface Aqueduct {
    ConduitIn in();
    int threads();
    void threads(int count);
}
