package leapstream.scoreboard.legacy.ui.swing.pear;

import leapstream.scoreboard.legacy.ui.core.Ui;
import leapstream.scoreboard.legacy.ui.swing.type.FontRatio;
import leapstream.scoreboard.legacy.ui.swing.type.FontSpec;

import javax.swing.Icon;
import java.awt.Color;

public interface Label extends Ui {
    String text();
    void text(String s);
    Color fg();
    void fg(Color c);
    Color bg();
    void bg(Color c);
    void icon(Icon i);
    // FIX 1915 Dec 24, 2008 Not sure about this sucker.
    void font(FontRatio ratio);
    void font(FontSpec spec);
}
