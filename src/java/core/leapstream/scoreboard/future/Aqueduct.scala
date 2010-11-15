package leapstream.scoreboard.future

import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy
import java.util.concurrent._

class Aqueduct(poolsize: Int, timebox: Int) {
  val executor = new ThreadPoolExecutor(2, poolsize, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue[Runnable], new CallerRunsPolicy)

  def conduit[A](in: () => A, out: A => Unit, errorx: Throwable => Unit, timeout: Int => Unit) = {
    val pipe = new Runnable {
      def run = out(in())
    }
    val resilient = Resilient.nu(pipe, errorx, timeout, timebox)
    executor.execute(resilient)
  }
}