package leapstream.scoreboard

import alien.ui.core.Ui
import alien.ui.swing.pear.Frame
import config.DefaultConfig
import core.pylon.PylonX
import future.Aqueduct
import java.net.URL
import au.net.netstorm.boost.bullet.time.core.Duration
import au.net.netstorm.boost.bullet.roughly.Roughly
import model.Score
import pylons.core._
import io.mth.phonic.Phonic

object Main {
  def main(args: Array[String]) {
    val phonic = new Phonic()
    phonic.start
    val pollperiod = 120 * 1000L;
    val config = DefaultConfig
    val aqueduct = new Aqueduct(config.threadpool.threads, config.threadpool.timeout)
    val roughly = new Roughly {
      def is(p1: Duration) = "" + p1.millis
    }
    val hudson = new ScorePylon(new URL("http://www.leapstream.com.au/products/scoreboard/samples/hudson/hudson-hornet"), config, roughly)
    val loading = LoadingScreen.nu("hornet")
    val jollyroger = JollyRoger.nu("hornet")
    val failable = Failable.failable(loading, hudson.ui, jollyroger)
//    val hudson = new StatusPylon(new URL("http://www.leapstream.com.au/products/scoreboard/samples/hudson/hudson-hornet"), "fred")
    val pylon = new PylonX {
      def view = new Ui {
        def ui = failable
      }

      def mandatory = true

      def name = throw new IllegalStateException
    }

    val scoreboard = new Scoreboard

    scoreboard.ui.add(pylon.view.ui)
    scoreboard.pylons.add(pylon)

    val scheduler = new Scheduler(config.threadpool.threads)
    scheduler.schedule(
        aqueduct.conduit(hudson.build, (a: Score) => {failable.ok; hudson.ok(a)}, _ => failable.fail, _ => failable.fail)
        , pollperiod
      )

    println("done")

    val frame = new Frame
    frame.getContentPane.add(scoreboard.ui)
    frame.pack()
    frame.setVisible(true)
  }
}