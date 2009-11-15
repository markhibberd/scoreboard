package leapstream.scoreboard.core.pylon;

public final class DefaultPylonSticker implements PylonSticker {
    PylonWirer wirer;

    public void optional(PylonView pylon) {
        wirer.wire(pylon, false);
    }

    public void mandatory(PylonView pylon) {
        wirer.wire(pylon, true);
    }
}
