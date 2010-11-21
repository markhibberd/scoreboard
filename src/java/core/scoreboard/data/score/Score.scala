package leapstream.scoreboard.data.score

import java.util.Date



case class Score(name: Name, state: State, timestamp: Date, history: List[Run])
case class State(status: Status, since: Date)
case class Run(id: String, result: Result, timestamp: Date)

sealed trait Status
case object Waiting extends Status
case object Queued extends Status
case object Building extends Status
case object Disabled extends Status
case object Errored extends Status

sealed trait Result
case object Error extends Result
case object Success extends Result
case object Failure extends Result


