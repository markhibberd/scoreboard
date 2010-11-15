package leapstream.scoreboard.pylons.core

import javax.swing.JComponent
import leapstream.scoreboard.alien.ui.swing.pear.Panel
import leapstream.scoreboard.core.ui.layout.{DefaultBoardLayoutManager, BoardLayoutManager}

class Scoreboard {
  val ui = new Panel {
    val lm = new DefaultBoardLayoutManager
    setLayout(lm)
  }

  // FIX smelly smelly
  def pylons = ui.lm.pylons()
}
