package leapstream.scoreboard.alien.ui.gunge.aspect;

import java.awt.Dimension;

// FIX 377 Home?  Where does this belong.
public interface AspectAdjuster {
    Dimension adjustw(Dimension v, Dimension aspect);
    Dimension adjusth(Dimension v, Dimension aspect);
    Integer adjustw(int w, Dimension aspect);
    Integer adjusth(int h, Dimension aspect);
}
