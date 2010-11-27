package scoreboard

import launch.BoardConsole
import java.io.PrintWriter

object Main {
  import io.mth.pirate._

  case class ScoreboardArgs(
        help: Boolean = false,
        version: Boolean = false,
        verbose: Boolean = false,
        expressions: List[String] = List(),
        console: Boolean = false,
        configs: List[String] = List())

  val cmd = command[ScoreboardArgs]("scoreboard") <|>
              flag('h', "help", "print this usage message to standard out")(_.copy(help = true)) <|>
              flag('V', "version", "print the scoreboard version to standard out")(_.copy(version = true)) <|>
              flag('v', "verbose", "enable verbose logging")(_.copy(verbose = true)) <|>
              flag('c', "console", "drop into the console after startup (this is the default if no config specified)")(_.copy(console = true)) <|>
              flag1('e', "eval", "evaluate the expression instead of dropping into the console", "EXPR")((s, e) => s.copy(expressions = s.expressions ::: List(e))) >|
              positional0plus("CONFIG")((s, configs) => s.copy(configs = s.configs ::: configs))

  def main(args: Array[String]) {
    val exitcode = cmd.dispatch(args.toList, ScoreboardArgs()) { a =>
      // TODO args are ignored, implement logic.... eh? what can I say...
      val console = new BoardConsole(a.configs, None, new PrintWriter(System.out), new PrintWriter(System.err))
      console.run
    }
    exit(exitcode)
  }
}