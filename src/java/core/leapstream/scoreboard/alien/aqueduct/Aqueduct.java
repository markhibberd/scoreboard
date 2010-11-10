package leapstream.scoreboard.alien.aqueduct;

// FIX AQUEDUCT Push to boost.
public interface Aqueduct {
    ConduitIn in();
    int threads();
    void threads(int count);
}
