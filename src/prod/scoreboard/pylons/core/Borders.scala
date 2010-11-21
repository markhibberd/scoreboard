package leapstream.scoreboard.pylons.core

import javax.swing.BorderFactory
import javax.swing.border.Border
import java.awt.Color

import java.awt.Color.BLACK
import java.awt.Color.WHITE


object Borders {
  def border(o: Int, i: Int): Border = {
    val outer = line(WHITE, o)
    val inner = line(BLACK, i)
    return BorderFactory.createCompoundBorder(outer, inner)
  }


  private def line(color: Color, thickness: Int): Border = {
    return BorderFactory.createLineBorder(color, thickness)
  }

}