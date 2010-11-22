package leapstream.scoreboard.pylons.core

import scala.collection.JavaConversions._
import javax.swing.JComponent
import leapstream.scoreboard.legacy.ui.swing.pear.Panel
import leapstream.scoreboard.legacy.ui.layout.{DefaultBoardLayoutManager, BoardLayoutManager}

class Scoreboard(mandatory: List[JComponent], optional: List[JComponent]) {
  val ui = new Panel {
    val lm = new DefaultBoardLayoutManager(mandatory, optional)
    setLayout(lm)
  }

  mandatory.foreach(ui.add(_))
  optional.foreach(ui.add(_))
}
