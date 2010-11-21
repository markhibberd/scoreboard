package leapstream.scoreboard.pylons.core

import leapstream.scoreboard.alien.ui.swing.pear.{ShimLabel, Panel}
import java.awt.Color
import leapstream.scoreboard.model._
import scala.io.Source
import java.net.URL
import util.parsing.input.CharSequenceReader

// FIX split
class StatusPylon(url: URL, name: String) extends Pylon[Score] {
  val ui = new Panel {
    setBorder(Borders.border(2, 1))
    val label = new ShimLabel
    label.fontRatio(0.1)
    label.text(name)
    add(label)
  }

  // FIX De dupify
  def build(): Score = {
    val source = Source.fromURL(url)
    val feed = source.getLines.mkString("\n")
    val result = ScoreParser.score(new CharSequenceReader(feed))
    result.get
  }

  def bg(score: Score) =
    if (score.state.status == Disabled)
      Color.GRAY
    else
      score.history.headOption.map(_.result match {
        case Success => Color.GREEN
        case Failure => Color.RED
        case Error => Color.RED
      }).getOrElse(Color.GREEN)


  def fg(score: Score) = score.state.status match {
      case Building => Color.WHITE
      case _ => Color.BLACK
  }

  def ok(score: Score): Unit ={
    ui.label.bg(bg(score));
    ui.label.fg(fg(score))
  }
}