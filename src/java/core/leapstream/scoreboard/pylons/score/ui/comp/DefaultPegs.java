package leapstream.scoreboard.pylons.score.ui.comp;

import au.net.netstorm.boost.bullet.incredibles.core.Weaken;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.gunge.border.Borders;
import leapstream.scoreboard.alien.ui.swing.pear.Panel;
import leapstream.scoreboard.core.model.History;
import static leapstream.scoreboard.core.model.Result.SUCCESS;
import leapstream.scoreboard.core.model.Run;
import leapstream.scoreboard.pylons.score.ui.lf.Colors;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import static java.lang.Math.min;
import java.util.List;

public final class DefaultPegs implements Widget<Pegs>, Pegs, Constructable {
    int count = 11;
    LayoutManager layout = new GridLayout(count, 1);
    Panel panel = new Panel();
    Peg[] pegs = new Peg[count];
    Borders borders;
    Nu nu;
    Colors colors;
    Weaken weaken;

    public void constructor() {
        panel.setLayout(layout);
        add();
        colors();
    }

    private void colors() {
        Color bg = colors.get("pegs.active.bg");
        panel.setBackground(bg);
    }

    public Pegs control() {
        return this;
    }

    public JComponent ui() {
        return panel;
    }

    public void history(History history) {
        List<Run> runs = weaken.w(history);
        int size = runs.size();
        int limit = min(size, count);
        for (int i = 0; i < limit; ++i) poke(runs, i);
    }

    private void poke(List<Run> runs, int i) {
        Run run = runs.get(i);
        Peg peg = pegs[i];
        poke(run, peg);
    }

    private void poke(Run run, Peg peg) {
        boolean good = run.result() == SUCCESS;
        peg.good(good);
    }

    private void add() {
        for (int i = 0; i < count; i++) add(i);
    }

    private void add(int i) {
        // FIX 244 Dodgy cast, need to sort this widget crud.
        Widget<Peg> peg = (Widget<Peg>) nu.nu(Peg.class);
        pegs[i] = peg.control();
        JComponent ui = peg.ui();
        panel.add(ui);
    }
}
