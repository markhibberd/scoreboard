package leapstream.scoreboard.data.score

import util.parsing.combinator._
import java.util.Date
import leapstream.scoreboard.data.{score => model}

/*

 */
object ScoreParser extends Parsers {
  type Elem = Char

  def result = success | error | failure
  def success = acceptSeq("SUCCESS") ^^^ model.Success
  def error = acceptSeq("ERROR") ^^^ model.Error
  def failure = acceptSeq("FAILURE") ^^^ model.Failure


  def status = waiting | queued | building | disabled | errored
  def waiting = acceptSeq("WAITING") ^^^ model.Waiting
  def queued = acceptSeq("QUEUED") ^^^ model.Queued
  def building = acceptSeq("BUILDING") ^^^ model.Building
  def disabled = acceptSeq("DISABLED") ^^^ model.Disabled
  def errored = acceptSeq("ERRORED") ^^^ model.Errored

  def name = acceptSeq("Name[") ~ alphanumseps ~ acceptSeq("]") ^^ { case a ~ b ~ c => b.mkString}

  def namex = acceptSeq("name=") ~> name

  def id = acceptSeq("Id[") ~ alphanumseps ~ acceptSeq("]") ^^ { case a ~ b ~ c => b.mkString}

  def idx = ((whitespace ~ acceptSeq("id=")) ~> id )

  def timepoint = acceptSeq("TimePoint[") ~ digits ~ acceptSeq("]") ^^ { case a ~ b ~ c => new Date(java.lang.Long.parseLong(b.mkString))}

  def digits = digit+

  def digit = elem("digit", _.isDigit)

  def alphanums = alphanum+

  def alphanum = elem("alphanumeric", _.isLetterOrDigit)

  def alphanumseps = alphanumsep+

  def alphanumsep = alphanum | '-' | '_' | ' ' | '.' | ':' | ','

  def whitespaceChar = elem("whitespace", Character.isWhitespace(_))

  def whitespace = (whitespaceChar*)

  def run = (acceptSeq("Run[") ~ whitespace ~ acceptSeq("timestamp=")) ~> timepoint ~ idx ~ ((whitespace ~ acceptSeq("result=")) ~> result <~ (whitespace ~ acceptSeq("]"))) ^^ {case timepoint ~ id ~ result => Run(id, result, timepoint)}

  def separator = whitespace ~ ',' ~ whitespace

  def history = acceptSeq("history=History[[") ~> repsep(run, separator) <~ acceptSeq("]]")

  def state = (acceptSeq("status=Status[") ~ whitespace ~ acceptSeq("is=")) ~> status ~ ((whitespace ~ acceptSeq("since=")) ~> timepoint) <~ (whitespace ~ acceptSeq("]")) ^^ {case status ~ timepoint => State(status, timepoint)}

  def timestamp = acceptSeq("timestamp=") ~> timepoint

  def score = (whitespace ~ acceptSeq("Score[") ~ whitespace) ~> namex ~ (whitespace ~> timestamp) ~ (whitespace ~> state) ~ (whitespace ~> history) <~ (whitespace ~ acceptSeq("]")) ^^ {case name ~ timestamp ~ state ~ history => Score(name, state, timestamp, history)}
}