package leapstream.scoreboard.alien.ui.swing.containers;

import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.alien.ui.core.Ui;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;

import javax.swing.JComponent;
import java.awt.CardLayout;

public class DefaultFailable implements Failable, Constructable {
    private static final String FAIL = "FAIL";
    private static final String OK = "OK";
    private CardLayout layout;
    private Ui fail;
    private Ui ok;
    Panel panel;

    public DefaultFailable(Ui ok, Ui fail) {
        this.ok = ok;
        this.fail = fail;
    }

    public void constructor() {
        layout = new CardLayout();
        panel.setLayout(layout);
        add(ok, OK);
        add(fail, FAIL);
    }

    public void fail() {
        layout.show(panel, FAIL);
    }

    public void ok() {
        layout.show(panel, OK);
    }

    public JComponent ui() {
        return panel;
    }

    private void add(Ui target, String name) {
        JComponent ui = target.ui();
        panel.add(ui, name);
    }
}
