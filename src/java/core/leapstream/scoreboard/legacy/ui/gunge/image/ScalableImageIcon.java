package leapstream.scoreboard.legacy.ui.gunge.image;

import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public final class ScalableImageIcon extends ImageIcon {
    public ScalableImageIcon(byte[] bytes) {
        super(bytes);
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Image image = getImage();
        Rectangle box = scale(c, image);
        g.drawImage(image, box.x, box.y, box.width, box.height, c);
        // FIX 474 Playing around with scaling. This works and looks awesome but is really crappy, slow code.
//        Image scaled = image.getScaledInstance(box.width, box.height, SCALE_SMOOTH);
//        // FIX 474 Not sure why you have to set the image before it is drawn.
//        setImage(scaled);
//        g.drawImage(scaled, box.x, box.y, box.width, box.height, c);
//        setImage(image);
    }

    // FIX 474 Clean up and pull out aspect maintaing, scaling code. Look at AspectAdjuster.
    private Rectangle scale(Component c, Image image) {
        double ia = aspect(image);
        double ca = aspect(c);
        return ia < ca ? fixedHeight(c, ia) : fixedWidth(c, ia);
    }

    private double aspect(Image image) {
        int w = image.getWidth(null);
        int h = image.getHeight(null);
        return aspect(w, h);
    }

    private double aspect(Component c) {
        int w = c.getWidth();
        int h = c.getHeight();
        return aspect(w, h);
    }

    private Rectangle fixedHeight(Component c, double aspect) {
        int w = (int) (c.getHeight() * aspect);
        int h = c.getHeight();
        int x = (c.getWidth() - w) / 2;
        int y = 0;
        return new Rectangle(x, y, w, h);
    }

    private Rectangle fixedWidth(Component c, double aspect) {
        aspect = 1 / aspect;
        int w = c.getWidth();
        int h = (int) (c.getWidth() * aspect);
        int x = 0;
        int y = (c.getHeight() - h) / 2;
        return new Rectangle(x, y, w, h);
    }

    private double aspect(int w, int h) {
        double dw = (double) w;
        double dh = (double) h;
        return dw / dh;
    }
}
