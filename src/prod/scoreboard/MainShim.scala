package leapstream.scoreboard

import scoreboard.launch.Board
import leapstream.scoreboard.data.config.DefaultConfig

object MainShim {
  def main(args: Array[String]) {
    val board = new Board(DefaultConfig)
    board.start
  }
}