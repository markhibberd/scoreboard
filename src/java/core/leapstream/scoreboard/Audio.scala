package leapstream.scoreboard

import java.util.concurrent.LinkedBlockingQueue
import java.net.URL

class Audio {
  val in = new LinkedBlockingQueue[Playable]

  val audio = new Thread(new Runnable {
    def run: Unit = {
      while (true) {
        try {
          val p = in.take
          p.play
        } catch {
          case e: InterruptedException => return
        }
      }
    }
  })
  audio.setDaemon(true)
  audio.start()

  def play(p: Playable) = in.add(p)
}

trait Playable {
  def play

  def :>:(p: Playable) = new Playable {
    this.play
    p.play
  }

  def :<:(p: Playable) = new Playable {
    p.play
    this.play
  }
}

object Playable {
  def say(s: String) = new Playable {
    asf
  }
  def play(wab: URL) = new Playable {
    asfasf    
  }
}