package leapstream.scoreboard.alien.ui.dialog;

import au.net.netstorm.boost.gunge.optional.Optional;

public interface InputDialog {
    Optional<String> dialog(String message);
}
