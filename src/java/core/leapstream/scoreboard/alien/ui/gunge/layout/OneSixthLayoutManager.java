package leapstream.scoreboard.alien.ui.gunge.layout;

import javax.swing.JComponent;
import java.awt.Container;
import java.awt.Dimension;

// FIX LIFECYCLE Genericise TileLayout. Should be able to do stuff like this with it. 
public class OneSixthLayoutManager extends BoomLayoutManager {
    private JComponent head;
    private JComponent tail;

    public OneSixthLayoutManager(JComponent head, JComponent tail) {
        this.head = head;
        this.tail = tail;
    }

    public Dimension preferredLayoutSize(Container container) {
        return new Dimension(10, 10);
    }

    public void layoutContainer(Container container) {
        Dimension canvas = container.getSize();
        int oneSixth = canvas.height / 6;
        int fiveSixths = canvas.height - oneSixth;
        head.setBounds(0, 0, canvas.width, fiveSixths);
        tail.setBounds(0, fiveSixths, canvas.width, oneSixth);
    }
}
