package scoreboard

import launch.BoardConsole
import java.io.PrintWriter

object Main {
  def main(args: Array[String]) {
    def usage = """
        |  scoreboard [-h] [-V] [-e expression] [-c] [<config.scala> ...]
        |
        |  Options:
        |   -e, --eval <expression>        evalute expression instead of dropping
        |                                  into console.
        |   -c, --console                  drop into console after startup (this
        |                                  is the default if no config specified)
        |   -h, --help                     display this usage message
        |   -V, --version                  display version information
        |
        |  Arguments:
        |   <config.scala>                 config file, in scala. commands run as
        |                                  per console. Config is optional, no
        |                                  config is equivalent to `--console`.
        |
    """.stripMargin


    val console = new BoardConsole(args.toList, None, new PrintWriter(System.out), new PrintWriter(System.err))
    console.run
  }
}