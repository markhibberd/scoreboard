package leapstream.scoreboard.async

class Aqueduct(timebox: Int) {
  def conduit[A](in: () => A, out: A => Unit, errorx: Throwable => Unit, timeout: Int => Unit) = {
    val pipe = new Runnable {
      def run = out(in())
    }
    Resilient.nu(pipe, errorx, timeout, timebox)
  }
}