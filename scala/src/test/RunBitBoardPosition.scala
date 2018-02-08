package test

import logic.board.Bits.Board
import logic.board.{Bits, LongToBase}

import scala.language.postfixOps


object RunBitBoardPosition {
  def main(args: Array[String]): Unit = {
    val run = new RunBitBoardPosition
    run.testBits()
    run.boardPosition()
    run.plainBits()
    run.manipulateBits()
    run.boardLocalization()
  }
}

class RunBitBoardPosition {
  val Column = Array('a','b','c','d','e','f','g','h')
  val Row = Array('1','2','3','4','5')

  def boardPosition(): Unit = {
    println("-------------------------------------------------------")
    println("Displays Bit Positioning ")
    for (row <- 0 to 4; col <- 0 to 7) yield {
      val pos: Board = Bits.at(row, col)
      println("Position[col,row](" + Column(col) +  "," + Row(row) + ") => " + pos)
    }
  }


  def boardLocalization(): Unit = {
      println("--- boardLocalization ----------------------------------------------------")

    val s = '_' // byte separator

    val a1_ ="00000001_00000000_00000000_00000000_00000000_00000000_00000000".filterNot(s==)
    val a2_ ="00000000_10000000_00000000_00000000_00000000_00000000_00000000".filterNot(s==)

    /* INITIAL_TOP
        Capture	Color
              ^ ^
    Top Four	0	1	2	3  (4 specialized bits)
              0 0 0 0

    Groups	0	1	2	3	4	5	6	7	8	9
    0	      0	0	0	0	0	0	0	0	0	0	Empty Group
    1	      0	1	1	1	1	1	1	1	1	1
    2	      0	1	1	1	1	1	1	1	1	1
    3	      0	1	0	1	0	0	1	0	1	0
    4	      0	0	0	0	0	0	0	0	0	0	Empty Group
    5	      0	0	0	0	0	0	0	0	0	0	Empty Group
        Empty First Column
    */
    val it_ ="00000001_11111111_01111111_11010100_10100000_00000000_00000000".filterNot(s==)

    val a1: Board = new LongToBase(a1_).b
    val a2: Board = new LongToBase(a2_).b
    val it =   new LongToBase(it_).b
    assert(a1 ==  Bits.at(0, 0))
    assert(a2 ==  Bits.at(0, 1))
    assert(it ==  Bits.INITIAL_TOP)


  }

  def displayBits(): Unit = {
    println("-------------------------------------------------------")
    println("Displays HEX In Decimal")
    println("INITIAL_TOP: " + Bits.INITIAL_TOP)
    println("INITIAL_BOT: " + Bits.INITIAL_BOT)
    println("TOP_ROW: " + Bits.TOP_ROW)
    println("BOTTOM_ROW: " + Bits.BOTTOM_ROW)
    println("LEFT_COL: " + Bits.LEFT_COL)
    println("RIGHT_COL: " + Bits.RIGHT_COL)
    println("DIAGONAL: " + Bits.DIAGONAL)
    println("ON_BOARD: " + Bits.ON_BOARD)
    println("CENTER: " + Bits.CENTER)
    println("-------------------------------------------------------")
  }

  def testBits(): Unit = {
    val myPieces = Bits.INITIAL_BOT | Bits.IS_WHITE
    val opponentPieces = Bits.INITIAL_TOP
    println("myPieces: " + myPieces + " opponentPieces: " + opponentPieces)

    val myPieceCount: Int = Bits.count(myPieces)
    val oppPieceCount: Int = Bits.count(opponentPieces)

    println("myPieces Count: " + myPieceCount + " opponentPieces Count: " + oppPieceCount)

  }

  def plainBits(): Unit = {
    println("-------------------------------------------------------")

    val white = new LongToBase("0100000000000000000000000000000000000000000000000000000000000000").b
    assert(white == Bits.IS_WHITE)

    /* Sign bit throws a java.lang.NumberFormatException:
    val captured = new LongToBase("1000000000000000000000000000000000000000000000000000000000000000").b
    assert(captured == Bits.CAPTURED)
    */

  }

  def manipulateBits(): Unit = {

    val a = new LongToBase("00111100").b // 60
    val b = new LongToBase("00001111").b // 13

    println("a & b = " + (a & b)) /* 12 = 0000 1100 */
    println("a | b = " + (a | b)) /* 61 = 0011 1101 */
    println("a ^ b = " + (a ^ b)) /* 49 = 0011 0001 */
    println("~a = " + ~a) /* -61 = 1100 0011 */
    println("a << 2 = " + (a << 2)) /* 240 = 1111 0000 */
    println("a >> 2  = " + (a >> 2)) /* 15 = 1111 */
    println("a >>> 2 = " + (a >>> 2)) /* 15 = 0000 1111 */
    println("a >>> 6 = " + (a >>> 5)) /* 1 = 0000 0001 */
  }


}
