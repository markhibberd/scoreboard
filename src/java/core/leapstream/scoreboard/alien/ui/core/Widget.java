package leapstream.scoreboard.alien.ui.core;

import au.net.netstorm.boost.bullet.incredibles.core.Struct;

public interface Widget<T> extends Control<T>, Ui, Struct {
    String[] _ = {"control", "ui"};
}
