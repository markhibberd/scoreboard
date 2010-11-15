package leapstream.scoreboard.model

import org.scalatest.FunSuite
import util.parsing.input.CharSequenceReader

class ScoreParserTest extends FunSuite {
  import ScoreParser._

  val s = """
  Score[
    name=Name[hudson-hornet]
    timestamp=TimePoint[1233879405988]
    status=Status[
        is=WAITING
        since=TimePoint[1233819129000]
    ]
    history=History[[Run[
        timestamp=TimePoint[1233819129000]
        id=Id[1037]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1233812662000]
        id=Id[1036]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1233809422000]
        id=Id[1035]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1233053277000]
        id=Id[1034]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1233015277000]
        id=Id[1033]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1232797865000]
        id=Id[1032]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1232794986000]
        id=Id[1031]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1232686505000]
        id=Id[1030]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1232664796000]
        id=Id[1029]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1232664511000]
        id=Id[1028]
        result=SUCCESS
    ], Run[
        timestamp=TimePoint[1232664345000]
        id=Id[1027]
        result=SUCCESS
    ]]]
]
"""
val r = """Run[
        timestamp=TimePoint[1232664345000]
        id=Id[1027]
        result=SUCCESS
    ]"""


  test("parse run") {
    val result = ScoreParser.run(new CharSequenceReader(r))
    println(result)
  }

  test("parse score") {
    val result = score(new CharSequenceReader(s))
    println(result)
  }
}