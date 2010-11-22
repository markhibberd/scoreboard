package scoreboard.launch

import io.mth.phonic.Phonic
import leapstream.scoreboard.legacy.ui.swing.pear.Frame
import leapstream.scoreboard.async.{Aqueduct, Scheduler}
import leapstream.scoreboard.pylons.core._
import leapstream.scoreboard.data.config.Config

class Board(config: Config) {
  val audio = new Phonic
  val frame = new Frame
  val scheduler = new Scheduler(config.threadpool.threads)
  val aqueduct = new Aqueduct(config.threadpool.timeout)

  val pylons = config.tiles.map { case (name, mandatory, t, poll) =>
    val tile = t(config)
    val loading = LoadingScreen.nu(name)
    val jollyroger = JollyRoger.nu(name)
    val wrapped = Failable.failable(loading, tile.ui, jollyroger)



    def cond[A](t: Pylon[A]) = {
      var last: Option[A] = None
      aqueduct.conduit(t.build, (a: A) => {wrapped.ok; t.ok(a, last); last = Some(a)}, _ => wrapped.fail, _ => wrapped.fail)
    }
    
    val conduit = cond(tile)

    (name, mandatory, tile, poll, conduit, wrapped)
  }

  // FIX NavigableTiles
  val scoreboard = new Scoreboard(
    pylons filter { case (name, mandatory, tile, poll, conduit, wrapped) =>
      mandatory
    } map { case (name, mandatory, tile, poll, conduit, wrapped) =>
      wrapped
    },
    pylons.filter { case (name, mandatory, tile, poll, conduit, wrapped) =>
      !mandatory
    } map { case (name, mandatory, tile, poll, conduit, wrapped) =>
      wrapped
    }
  )


  def start = {
    audio.start
    frame.getContentPane.add(scoreboard.ui)
    frame.pack
    frame.setVisible(true)
    pylons.foreach { case (name, mandatory, tile, poll, conduit, wrapped) =>
      scheduler.schedule(conduit, poll)
    }
    // FIX Listenter
  }


  def stop = {
    scheduler.pool.shutdownNow
    audio.stop
    frame.setVisible(false)
    frame.removeAll
  }

}