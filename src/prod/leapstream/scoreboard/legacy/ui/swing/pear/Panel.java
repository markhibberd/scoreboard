package leapstream.scoreboard.legacy.ui.swing.pear;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.LayoutManager;

public class Panel extends JPanel {
    LayoutManager border = new BorderLayout();

    {
        setLayout(border);
    }
}
