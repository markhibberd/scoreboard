package leapstream.scoreboard.pylons.core

import leapstream.scoreboard.legacy.ui.swing.pear.{ShimLabel, Panel}
import leapstream.scoreboard.legacy.ui.gunge.image.ScalableImageIcon
import java.net.URL

// FIX split
class ImagePylon(url: URL) extends Pylon[Array[Byte]] {
  val ui = new Panel {
    val image = new ShimLabel
    setBorder(Borders.border(2, 1))
    add(image);
  }

  def build(): Array[Byte] = {
    val in = url.openStream
    try {
      (Iterator continually (in.read()) takeWhile (_ != -1)).map(_.toByte).toArray 
    } finally {
      in.close()
    }
  }


  def ok(data:Array[Byte], previous: Option[Array[Byte]]) =
    ui.image.icon(new ScalableImageIcon(data))
}