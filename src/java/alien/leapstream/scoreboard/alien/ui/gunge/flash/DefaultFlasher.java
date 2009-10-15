package leapstream.scoreboard.alien.ui.gunge.flash;

import javax.swing.JComponent;
import java.awt.Color;

public final class DefaultFlasher implements Flasher {
    private final Color[] sparkles;
    private final JComponent ui;
    private int index = 0;

    public DefaultFlasher(JComponent ui, Color... sparkles) {
        this.ui = ui;
        this.sparkles = sparkles;
    }

    public void run() {
        index = (index + 1) % sparkles.length;
        Color sparkle = sparkles[index];
        ui.setBackground(sparkle);
    }
}
