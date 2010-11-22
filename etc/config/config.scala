import leapstream.scoreboard.data.config.DefaultConfig
import leapstream.scoreboard.pylons.core._
import java.net._

val hornet = "http://www.leapstream.com.au/products/scoreboard/samples/hudson/hudson-hornet"
val config = DefaultConfig.copy( 
  tiles = List(
    ("hornet", true, ScorePylon(hornet), 5  * 1000)
  )
)
launch(config)

