package leapstream.scoreboard.pylons.core

import leapstream.scoreboard.data.score._
import leapstream.scoreboard.legacy.ui.swing.pear.{ShimLabel, Panel}
import leapstream.scoreboard.pylons.score.ui.layout.DefaultTileLayoutManager
import java.awt.{GridLayout, Color}
import au.net.netstorm.boost.bullet.roughly.Roughly
import au.net.netstorm.boost.bullet.time.core.Duration
import scala.io.Source
import java.net.URL
import util.parsing.input.CharSequenceReader
import leapstream.scoreboard.data.score.{Success, ScoreParser, Score}
import leapstream.scoreboard.data.config.Config

// FIX split
// FIX audio
// FIX log
// FIX flash
class ScorePylon(url: URL, config: Config, roughly: Roughly) extends Pylon[Score] {
  implicit def string2colour(s: String): Color = Colours.colour(s)
  
  val ui = new Panel {
    setBorder(Borders.border(2, 1))
    val title = new ShimLabel
    val pegs = new Panel {
      val peglings = (for (i <- 1 to 11) yield new Panel).toList
      peglings.foreach(_.setBackground(config.colours.peg.default))
      peglings.foreach(_.setBorder(Borders.border(1,1)))
      peglings.foreach(add(_))
      setBackground(config.colours.pegs.bg)
      setForeground(config.colours.pegs.fg)
      setLayout(new GridLayout(11, 1))
    }
    val dial = new ShimLabel
    dial.setBackground(Color.BLACK)
    dial.fontRatio(0.6)
    val status = new  ShimLabel
    status.setBackground(Color.BLACK)
    val freshness = new ShimLabel
    freshness.bg(config.colours.freshness.bg)
    freshness.fg(config.colours.freshness.fg)
    val parts = Array[java.awt.Component](title, pegs, dial, status, freshness)
    val lm = new DefaultTileLayoutManager
    lm.set(parts)
    setLayout(lm)

    add(title)
    add(pegs)
    add(dial)
    add(status)
    add(freshness)
  }

  // FIX de-dupe
  def build(): Score = {
    val source = Source.fromURL(url)
    val feed = source.getLines.mkString("\n")
    val result = ScoreParser.score(new CharSequenceReader(feed))
    result.get
  }

  def ok(score: Score): Unit = {
      println("updating")
      ui.title.bg(config.colours.title.bg)
      ui.title.fg(config.colours.title.fg)
      ui.title.text(score.name)
      ui.dial.bg(dialbg(score));
      ui.dial.fg(dialfg(score))
      ui.dial.text(score.history.filter(_.result == score.history.headOption.getOrElse(Success)).size.toString)
      ui.status.bg(status(score).bg)
      ui.status.fg(status(score).fg)
      ui.status.text(score.state.status.toString)
      ui.pegs.peglings.zip(score.history).foreach { case (p: Panel, r: Run) =>
        val c = if (r.result == Success) config.colours.peg.good else config.colours.peg.bad
        p.setBackground(c)
      }
      ui.freshness.text(freshness(score))
    }

  def freshness(score: Score) = {
    val reference = score.timestamp
    val since = score.state.since
    val duration = reference.getTime - since.getTime
    roughly.is(new Duration(duration))
  }

  def status(score: Score) = score.state.status match {
    case Waiting => config.colours.status.waiting
    case Queued => config.colours.status.queued
    case Building => config.colours.status.building
    case Disabled => config.colours.status.disabled
    case Errored => config.colours.status.error
  }


  def dialbg(score: Score) =
    if (score.state.status == Disabled)
      Color.GRAY
    else
      score.history.headOption.map(_.result match {
        case Success => Color.GREEN
        case Failure => Color.RED
        case Error => Color.RED
      }).getOrElse(Color.GREEN)


  def dialfg(score: Score) = score.state.status match {
      case Building => Color.WHITE
      case _ => Color.BLACK
  }


}