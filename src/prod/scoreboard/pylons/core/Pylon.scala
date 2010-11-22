package leapstream.scoreboard.pylons.core

import javax.swing.JComponent

trait Pylon[A] {
  val ui: JComponent

  def build(): A

  def ok(result: A, previous: Option[A]): Unit
}