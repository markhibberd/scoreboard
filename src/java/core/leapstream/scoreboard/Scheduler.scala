package leapstream.scoreboard

import java.util.concurrent._
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy

class Scheduler(size: Int) {
  val scheduler = Executors.newScheduledThreadPool(1);
  val pool = new ThreadPoolExecutor(size, size, 0,  TimeUnit.MILLISECONDS, new LinkedBlockingQueue[Runnable](), new CallerRunsPolicy())

  def schedule(runnable: Runnable, poll: Long) = {
    scheduler.scheduleWithFixedDelay(new Runnable {
      def run = pool.execute(runnable)
    }, 0L, poll, TimeUnit.MILLISECONDS)
  }
}