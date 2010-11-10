package leapstream.scoreboard.alien.ui.swing.pear;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import leapstream.scoreboard.alien.ui.swing.type.FontRatio;
import leapstream.scoreboard.alien.ui.swing.type.FontSpec;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;

public class _Label extends JLabel implements Label {
    private Dimension size = getSize();
    private FontRatio ratio;
    private FontSpec fonty;
    private Weaken weaken;

    // FIX 1915 Dec 29, 2008 Consistent naming scheme.  Use "_" for all UI components.
    // FIX 1596 Jan 9, 2009 Sort inheritance scoping. Then remove this from ctor
    public _Label(Weaken weaken) {
        this.weaken = weaken;
        // FIX 1915 Dec 23, 2008 Move initialisation out of here (recommend _LabelInit).
        init();
    }

    private void init() {
        setVerticalAlignment(CENTER);
        setHorizontalAlignment(CENTER);
        setOpaque(true);
    }

    // FIX 244 Without this size check shortcut the spinner (or any overlayed component) disappears.
    // FIX 244 Is there a better way of achieving this.
    public void paintComponent(Graphics g) {
        if (!sameSize()) fontme();
        super.paintComponent(g);
    }

    private void fontme() {
        Font font = new Font(fontname(), fontstyle(), height());
        setFont(font);
    }

    private boolean sameSize() {
        Dimension s = size;
        size = getSize();
        return size.equals(s);
    }

    private int fontstyle() {
        return fonty == null ? BOLD : fonty.style();
    }

    private String fontname() {
        return fonty == null ? "Helvetica" : fonty.name();
    }

    private int height() {
        Dimension size = getSize();
        return (int) (size.height * ratio());
    }

    private Double ratio() {
        return ratio == null ? .67 : weaken.w(ratio); // FIX 1915 Dec 24, 2008 Remove .67 magicness.
    }

    public String text() {
        return getText();
    }

    public void text(String s) {
        setText(s);
    }

    public Color fg() {
        return getForeground();
    }

    public void fg(Color c) {
        setForeground(c);
    }

    public Color bg() {
        return getBackground();
    }

    public void bg(Color c) {
        setBackground(c);
    }

    public void icon(Icon i) {
        setIcon(i);
    }

    public void font(FontRatio ratio) {
        this.ratio = ratio;
    }

    public void font(FontSpec fonty) {
        this.fonty = fonty;
    }

    public JComponent ui() {
        return this;
    }
}