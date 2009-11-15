package leapstream.scoreboard.alien.aqueduct;

public class DefaultAqueduct implements Aqueduct {
    Resivoir resivoir;
    Conduit conduit;

    public ConduitIn in() {
        return conduit;
    }

    public int threads() {
        return resivoir.threads();
    }

    public void threads(int count) {
        resivoir.threads(count);
    }
}
