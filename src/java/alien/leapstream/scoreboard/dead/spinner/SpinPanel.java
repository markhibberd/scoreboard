package leapstream.scoreboard.dead.spinner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

import leapstream.scoreboard.alien.ui.swing.pear.Panel;

public final class SpinPanel extends Panel implements Pokeable {
    private static final int COGS = 12;
    private static final int RATIO = 4;
    private AffineTransform[] transforms = new AffineTransform[COGS];
    private Shape pill;
    private int position;

    public void poke() {
        position = (position + (COGS-1)) % COGS;
        repaint();
    }

    public void paint(Graphics graphics) {
        paint((Graphics2D) graphics);
    }

    private void paint(Graphics2D g) {
        Dimension size = getSize();
        rendering(size, g);
        shapes(size);
        transforms(size);
        draw(g);
    }

    private void rendering(Dimension size, Graphics2D g) {
        g.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        // transparent on|off
//        g.clearRect(0, 0, size.width, size.height);
    }

    private void shapes(Dimension size) {
        int h = size.height / (RATIO * 3);
        int w = size.width / RATIO;
        pill = new RoundRectangle2D.Double(-w / 2, -h / 2, w, h, h, h);
    }

    private void transforms(Dimension size) {
        for (int i = 0; i < transforms.length; i++) {
            transforms[i] = transform(size, i);
        }
    }

    private void draw(Graphics2D g) {
        for (int i = 0; i < transforms.length; i++) draw(g, i);
    }

    private Color color(int i) {
        int s = 192 / COGS * ((i + position) % COGS);
        return new Color(s, s, s);
    }

    private AffineTransform transform(Dimension size, int i) {
        int w = size.width;
        int h = size.height;
        return transform(w, h, i);
    }

    private AffineTransform transform(int w, int h, int i) {
        AffineTransform result = new AffineTransform();
        double angle = Math.PI / (COGS / 2) * i;
        Point2D p = spoke(w, h, angle);
        result.translate(w / 2 + p.getX(), h / 2 + p.getY());
        result.rotate(angle);
        return result;
    }

    private Point2D spoke(double w, double h, double angle) {
        double x = (Math.cos(angle) * w / RATIO) * 1.5;
        double y = (Math.sin(angle) * h / RATIO) * 1.5;
        return new Point2D.Double(x, y);
    }

    private void draw(Graphics2D g, int i) {
        Color c = color(i);
        g.setColor(c);
        g.setTransform(transforms[i]);
        g.fill(pill);
    }
}
