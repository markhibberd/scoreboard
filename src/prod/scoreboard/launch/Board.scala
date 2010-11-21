package scoreboard.launch

import io.mth.phonic.Phonic
import leapstream.scoreboard.legacy.ui.swing.pear.Frame
import leapstream.scoreboard.data.score._
import leapstream.scoreboard.async.{Aqueduct, Scheduler}
import au.net.netstorm.boost.bullet.roughly.Roughly
import au.net.netstorm.boost.bullet.time.core.Duration
import leapstream.scoreboard.pylons.core._
import java.net.URL
import leapstream.scoreboard.legacy.pylon.PylonX
import leapstream.scoreboard.legacy.ui.core.Ui
import leapstream.scoreboard.data.config.Config

class Board(config: Config) {
  val audio = new Phonic
  val frame = new Frame
  val scheduler = new Scheduler(config.threadpool.threads)
  val aqueduct = new Aqueduct(config.threadpool.timeout)
  val scoreboard = new Scoreboard
  scoreboard.ui.add(pylon.view.ui)
  scoreboard.pylons.add(pylon)

  /*
   * Faked roughly, port or replace.
   */
  val roughly = new Roughly {
    def is(p1: Duration) = "" + p1.millis
  }


  /*
   * Dummy tile for now. =================================
   */

  val pollperiod = 120 * 1000L;
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

  val conduit = aqueduct.conduit(hudson.build, (a: Score) => {failable.ok; hudson.ok(a)}, _ => failable.fail, _ => failable.fail)


  /*
   * End of dummy tile =================================
   */


  def start = {
    audio.start
    scheduler.schedule(conduit, pollperiod) // part of the dummy tile

    frame.getContentPane.add(scoreboard.ui)
    frame.pack
    frame.setVisible(true)
  }


  def stop = {
    scheduler.pool.shutdownNow
    audio.stop
    frame.setVisible(false)
    frame.removeAll
  }

}