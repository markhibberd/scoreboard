package leapstream.scoreboard.core.pylon;

public final class DefaultPylons implements PylonSticker {
    PylonWirer wirer;

    public void optional(Pylon pylon) {
        wirer.wire(pylon, false);
    }

    public void mandatory(Pylon pylon) {
        wirer.wire(pylon, true);
    }
}
