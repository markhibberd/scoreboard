package leapstream.scoreboard.future

object Resilient {
  def nu(delegate: Runnable, errorx: Throwable => Unit, timeout: Int => Unit, time: Int) = new Runnable {
    def run = {
      val child = new Thread(new Runnable {
        def run = {
          try {
            delegate.run()
          } catch {
            case t: Throwable => errorx(t)
          }
        }
      })
      child.setDaemon(true)
      child.start()
      try {
        child.join(time)
      } catch {
        case t: Throwable => timeout(time)
      }
    }
  }
}