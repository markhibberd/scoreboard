package leapstream.scoreboard.core.entry;

import au.net.netstorm.boost.spider.api.entry.Go;
import au.net.netstorm.boost.spider.api.lifecycle.Constructable;
import leapstream.scoreboard.alien.ui.core.Widget;
import leapstream.scoreboard.alien.ui.swing.pear.Frame;
import leapstream.scoreboard.core.bits.Bits;
import leapstream.scoreboard.core.config.script.ConfiguratorLibraries;
import leapstream.scoreboard.core.ui.config.Config;
import leapstream.scoreboard.core.ui.widgets.Board;
import leapstream.scoreboard.edge.java.awt.FontStatic;
import leapstream.scoreboard.edge.java.io.InputStream;
import leapstream.scoreboard.pylons.score.ui.lf.Colors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

import static java.awt.Font.TRUETYPE_FONT;

// FIX 244 Tidy this guy, should be split out more. In particular the ui wiring should be pulled out together.
public final class ScoreboardGo implements Go, Constructable {
    private Color background;
    ConfiguratorLibraries libraries;
    ScoreboardArguments arguments;
    KeyListener listener;
    FontStatic font;
    Config config;
    Colors colors;
    Board board;
    Frame frame;
    Bits bits;


    public void constructor() {
        libraries.add("js", bits.url("core.js"));
        libraries.add("js", bits.url("utils.js"));
        background = colors.get("board.bg");
        // FIX 1530 Dec 12, 2008 Tidy font gear.
        InputStream is = bits.stream("Robotron.ttf");
        Font f = font.createFont(TRUETYPE_FONT, is);
        UIManager.put("Label.font", f);
    }

    public void go(String[] args) {
        // FIX replace this with some real command line processing, this is a quick start gone to far.
        arguments.process(args);
        wire();
        show();
        check(args);
    }

    private void wire() {
        Container c = frame.getContentPane();
        frame.setBackground(background);
        frame.addKeyListener(listener);
        board(c);
    }

    private void board(Container c) {
        // FIX 244 This cast is dodgy.
        Widget<Board> widget = (Widget<Board>) board;
        JComponent b = widget.ui();
        c.add(b);
    }

    private void show() {
        frame.pack();
        frame.setVisible(true);
    }

    private void check(String[] args) {
        if (args.length == 0) config.get();
    }
}
