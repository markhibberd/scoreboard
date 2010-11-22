package leapstream.scoreboard.pylons.core

import leapstream.scoreboard.legacy.ui.swing.pear.{ShimLabel, Panel}
import leapstream.scoreboard.legacy.ui.gunge.image.ScalableImageIcon
import java.awt.Color
import leapstream.scoreboard.legacy.ui.gunge.layout.OneSixthLayoutManager

object JollyRoger {
  lazy val bytes = {
    val in = classOf[Scoreboard].getClassLoader.getResourceAsStream("scoreboard/resources/image/Jolly-roger.png")
    try {
      (Iterator continually (in.read()) takeWhile (_ != -1)).map(_.toByte).toArray
    } finally {
      in.close()
    }
  }

  def nu(namex: String) = new Panel {
    setBorder(Borders.border(2, 1))
    val name = new ShimLabel
    name.fg(Color.WHITE)
    name.bg(Color.BLACK)
    name.text(namex)
    val image = new ShimLabel
    image.bg(Color.BLACK)
    val icon = new ScalableImageIcon(bytes)
    image.icon(icon)
    setLayout(new OneSixthLayoutManager(name, image))
    add(name)
    add(image)
  }
}