package scoreboard.launch

import java.io.{BufferedReader, PrintWriter}
import tools.nsc.GenericRunnerSettings
import java.net.URLClassLoader
import tools.nsc.io.File

class BoardConsole(configs: List[String], in: Option[BufferedReader], out: PrintWriter, err: PrintWriter) {
  val settings = new GenericRunnerSettings(err.println _)
  val cls = classOf[BoardConsole]
  val loader: URLClassLoader = cls.getClassLoader.asInstanceOf[URLClassLoader]
  val paths = loader.getURLs.map(x => x.getFile)
  paths.foreach(settings.classpath.append _)
  val x = new scala.tools.nsc.InterpreterLoop(in, out) {
    override def createInterpreter() {
      super.createInterpreter()
      interpreter.beQuietDuring {

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