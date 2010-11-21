package leapstream.scoreboard.data.config

object DefaultConfig extends Config (
  colours =    DefaultColours,
  window =     Window(title = "scoreboard"),
  threadpool = ThreadPool(threads = 5, timeout = 30000),
  tiles = List(),
  keys = List()
)


object DefaultColours extends Colours (
  board =     Colour(bg = "40000000", fg = "000000"),
  title =     Colour(bg = "000000", fg = "FFFFFF"),
  pegs =      Colour(bg = "000000", fg = "FFFFFF"),
  peg =       PegColours(
                good =     "00AA00",
                bad  =     "FF0000",
                default =  "000000"
              ),
  dial =      DialColours(
                good =     "00FF00",
                bad  =     "FF0000",
                building = "FFFFFF",
                flash =    "F3A600",
                quiet =    "000000"
              ),
  status =    StatusColours(
                waiting =  Colour(bg = "000000", fg = "FFFFFF"),
                queued =   Colour(bg = "FFFF00", fg = "000000"),
                building = Colour(bg = "00AA00", fg = "FFFFFF"),
                disabled = Colour(bg = "808080", fg = "000000"),
                error =    Colour(bg = "FF0000", fg = "000000")
              ),
  freshness = Colour(bg = "FFFFFF", fg = "000000")
)
