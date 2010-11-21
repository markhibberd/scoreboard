package leapstream.scoreboard.pylons.core

import leapstream.scoreboard.legacy.ui.swing.pear.{ShimLabel, Panel}
import java.awt.{GridLayout, Color}

object LoadingScreen {
  def nu(namex: String) = new Panel {
    setBorder(Borders.border(2, 1))
    val name = new ShimLabel
    name.fg(Color.WHITE)
    name.bg(Color.BLACK)
    name.fontRatio(0.1)
    name.text(namex)

    val loading = new ShimLabel
    loading.fg(Color.WHITE)
    loading.bg(Color.BLACK)
    loading.fontRatio(0.05)
    loading.text("loading ...")

    setLayout(new GridLayout(4, 1))
    add(new Panel { setBackground(Color.BLACK) })
    add(name)
    add(loading)
    add(new Panel { setBackground(Color.BLACK) })
  }
}