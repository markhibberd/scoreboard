package leapstream.scoreboard.pylons.core

import leapstream.scoreboard.legacy.ui.swing.pear.Panel
import java.awt.{Component, CardLayout}

object Failable {
  def failable(loadx: Component, okx: Component, failx: Component) = new Panel {
    val cards = new CardLayout
    setLayout(cards)
    add(okx.asInstanceOf[Component], "OK".asInstanceOf[Object])
    add(failx.asInstanceOf[Component], "FAIL".asInstanceOf[Object])
    add(loadx.asInstanceOf[Component], "LOAD".asInstanceOf[Object])
    cards.show(this, "LOAD")

    def ok = cards.show(this, "OK")

    def fail = cards.show(this, "FAIL")
  }
}