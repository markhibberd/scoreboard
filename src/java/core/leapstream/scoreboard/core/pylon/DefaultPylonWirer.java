package leapstream.scoreboard.core.pylon;

import leapstream.scoreboard.core.ui.widgets.Board;

public final class DefaultPylonWirer implements PylonWirer {
    Board board;

    public void wire(PylonView pylon, boolean mandatory) {
        view(mandatory, pylon);
    }

    private void view(boolean mandatory, PylonView pylon) {
        board.add(pylon, mandatory);
    }
}
