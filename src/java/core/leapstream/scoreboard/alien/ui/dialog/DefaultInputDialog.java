package leapstream.scoreboard.alien.ui.dialog;

import au.net.netstorm.boost.gunge.optional.NotSetOptional;
import au.net.netstorm.boost.gunge.optional.Optional;
import au.net.netstorm.boost.gunge.optional.SetOptional;

import javax.swing.JOptionPane;

public final class DefaultInputDialog implements InputDialog {
    public Optional<String> dialog(String message) {
        String s = JOptionPane.showInputDialog(message);
        // FIX 3191 Mar 5, 2009 BOLLOCKS Where's my factory frank
        return s != null ? new SetOptional(s) : new NotSetOptional();
    }
}
