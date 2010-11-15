package leapstream.scoreboard.config

import leapstream.scoreboard.core.pylon.PylonX
import leapstream.scoreboard.core.ui.key.Handler

case class Config(
          colours: Colours,
          window: Window,
          threadpool: ThreadPool,
          tiles: List[PylonX],
          keys: List[KeyBinding]
        )

case class KeyBinding(
          code: Int,
          action: Handler
        )

case class ThreadPool (
          threads: Int,
          timeout: Int
        )

case class Window(
          title: String
        )

case class Colours(
            board: Colour,
            title: Colour,
            pegs: Colour,
            peg: PegColours,
            dial: DialColours,
            status: StatusColours,
            freshness: Colour
        )

case class DialColours (
             good: String,
             bad: String,
             building: String,
             flash: String,
             quiet: String
        )

case class StatusColours (
             waiting: Colour,
             queued: Colour,
             building: Colour,
             disabled: Colour,
             error: Colour
        )

case class PegColours (
            good: String,
            bad: String,
            default: String
        )

case class Dial(
            building: String,
            quiet: String,
            good: String,
            bad: String,
            flash: String
        )

case class Colour(
          fg: String,
          bg: String
        )