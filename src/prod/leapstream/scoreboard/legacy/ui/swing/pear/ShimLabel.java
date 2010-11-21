package leapstream.scoreboard.legacy.ui.swing.pear;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;

public class ShimLabel extends JLabel {
    private Dimension size = getSize();
    private Double ratio;
    private String fontName;
    private int fontStyle;

    public ShimLabel() {
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
        return fontName == null ? BOLD : fontStyle;
    }

    private String fontname() {
        return fontName == null ? "Helvetica" : fontName;
    }

    private int height() {
        Dimension size = getSize();
        return (int) (size.height * ratio());
    }

    private Double ratio() {
        return ratio == null ? .67 : ratio; // FIX 1915 Dec 24, 2008 Remove .67 magicness.
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

    public void fontRatio(Double ratio) {
        this.ratio = ratio;
    }

    public void fontSpec(String name, int style) {
        this.fontName = name;
        this.fontStyle = style;
    }

    public JComponent ui() {
        return this;
    }
}