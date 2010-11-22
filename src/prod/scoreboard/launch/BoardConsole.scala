package scoreboard.launch

import java.io.{BufferedReader, PrintWriter}
import tools.nsc.GenericRunnerSettings
import java.net.URLClassLoader
import tools.nsc.io.File
import leapstream.scoreboard.data.config.Config

class BoardConsole(configs: List[String], in: Option[BufferedReader], out: PrintWriter, err: PrintWriter) {
  val settings = new GenericRunnerSettings(err.println _)
  val cls = classOf[BoardConsole]
  val loader: URLClassLoader = cls.getClassLoader.asInstanceOf[URLClassLoader]
  val paths = loader.getURLs.map(x => x.getFile)
  paths.foreach(settings.classpath.append _)

  val state = new BoardState

  val x = new scala.tools.nsc.InterpreterLoop(in, out) {
    override def createInterpreter() {
      super.createInterpreter()
      interpreter.beQuietDuring {
        interpreter.bind("launch", "scala.Function1[leapstream.scoreboard.data.config.Config,Unit]", state.launch)
//        interpreter.bind("close", "scala.Function1[Unit,Unit]", state.close)
      }
      configs.foreach( s =>
                interpretAllFrom(File(new java.io.File(s)))
        )
    }
  }

  def run {
    x.main(settings)
  }
}


class BoardState {
  var board: Option[Board] = None

  val launch = (c: Config) => {
    if (board.isDefined) {
      val b = board.get
      board = None
      b.stop
    }
    val b = new Board(c)
    board = Some(b)
    b.start
    ()
  }

  val close = () => {
    val b = board.get
    board = None
    b.stop
  }
}
