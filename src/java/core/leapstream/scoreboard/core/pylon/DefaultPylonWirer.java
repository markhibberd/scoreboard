package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.core.ui.widgets.Board;

public final class DefaultPylonWirer implements PylonWirer {
    Board board;

    public void wire(Pylon pylon, boolean mandatory) {
        view(mandatory, pylon);
        start(pylon);
    }

    private void view(boolean mandatory, Pylon pylon) {
        board.add(pylon, mandatory);
    }

    private void start(Pylon pylon) {
        pylon.start();
    }
}
