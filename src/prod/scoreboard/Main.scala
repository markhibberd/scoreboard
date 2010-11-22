package scoreboard

import launch.BoardConsole
import java.io.PrintWriter
import io.mth.pirate.PirateX._
import io.mth.pirate.PirateX

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
        |   -v, --verbose                  display verbose output
        |
        |  Arguments:
        |   <config.scala>                 config file, in scala. commands run as
        |                                  per console. Config is optional, no
        |                                  config is equivalent to `--console`.
        |
    """.stripMargin

    case class ScoreboardArgs(
            help: Boolean,
            version: Boolean,
            verbose: Boolean,
            expression: Option[String],
            console: Boolean,
            config: Option[String])

    def helparg: PirateX[ScoreboardArgs] = flag("-h", "--help", "display usage.", (a: ScoreboardArgs) => a.copy(help = true))
    def versionarg: PirateX[ScoreboardArgs] = flag("-V", "--version", "display version.", (a: ScoreboardArgs) => a.copy(version = true))
    def verbosearg: PirateX[ScoreboardArgs] = flag("-v", "--verbose", "verbose output.", (a: ScoreboardArgs) => a.copy(verbose = true))
    def consolearg: PirateX[ScoreboardArgs] = flag("-c", "--console", "drop into console.", (a: ScoreboardArgs) => a.copy(console = true))
//    val expressionarg = flag("-e", "--eval", "verbose output.", (a: ScoreboardArgs) => a.copy(verbose = true))
    def configarg: PirateX[ScoreboardArgs] = positional("config.scala", (a: ScoreboardArgs) => (s: String) =>  a.copy(config = Some(s)))
    def cmdline: PirateX[ScoreboardArgs] = line("scoreboard", List(helparg, versionarg, verbosearg, consolearg), List(configarg))

    def cmdlineargs = cmdline.parse(args.toList, ScoreboardArgs(false, false, false, None, false, None))

    if (!cmdlineargs.isDefined) {
      Console.println(cmdline.usage)
      Console.println("------")
      Console.println(usage)
      exit(1)
    }


    lazy val parsed = cmdlineargs.get
    lazy val normalised: ScoreboardArgs = if (parsed.config.isDefined) parsed else parsed.copy(console = true)


    if (normalised.help) {
      Console.println(cmdline.usage)
      Console.println("------")
      Console.println(usage)
      exit(0)
    }

    if (normalised.version) {
      Console.println("scoreboard version: TODO")
      exit(0)
    }


    val console = new BoardConsole(normalised.config.toList, None, new PrintWriter(System.out), new PrintWriter(System.err))
    console.run


  }
}