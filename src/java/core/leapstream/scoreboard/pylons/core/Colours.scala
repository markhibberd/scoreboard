package leapstream.scoreboard.pylons.core

import java.awt.Color

object Colours {
  def colour(s: String) = {
    val v = Integer.parseInt(s, 16)
    new Color(v, s.length > 6)
  }
}