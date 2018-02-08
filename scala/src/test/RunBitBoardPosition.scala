package test

import logic.board.Bits.Board
import logic.board.{Bits, LongToBase, StringBits}

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

  //  val Column = Array('a','b','c','d','e','f','g','h',i)
  object Column extends Enumeration {
    val a,b,c,d,e,f,g,h,i = Value
  }

  //  val Row = Array('1','2','3','4','5')
  object Row extends Enumeration {
    val I,II,III,IV,V = Value
  }

  def boardPosition(): Unit = {
    println("-------------------------------------------------------")
    println("Displays Bit Positioning")
    println("=> a1 is at the bottom left corner of the board ")
    println("=> i5 is at the top right corner of the board ")
    for (r <- 0 to 4; c <- 0 to 8) yield {
      val pos: Board = Bits.at(r, c)
      val column = Column(c)
      val row = Row(r).id + 1
      val msg = "Position[col,row](%s,%d) => %d "
      println(msg.format(column,row ,pos))
    }
  }


  def boardLocalization(): Unit = {
      println("--- boardLocalization ----------------------------------------------------")


    val aI_  ="00000001_00000000_00000000_00000000_00000000_00000000_00000000".filterNot(StringBits.S==)
    val aII_ ="00000000_10000000_00000000_00000000_00000000_00000000_00000000".filterNot(StringBits.S==)
    val iIV_ ="00000000_00000000_00000000_00000000_00000000_00000000_00000010".filterNot(StringBits.S==)
    val iV_  ="00000000_00000000_00000000_00000000_00000000_00000000_00000001".filterNot(StringBits.S==)

    assert(new LongToBase(aI_ ).b ==  Bits.at(0, 0))
    assert(new LongToBase(aII_).b ==  Bits.at(0, 1))
    assert(new LongToBase(iIV_).b ==  Bits.at(4, 7))
    assert(new LongToBase(iV_ ).b ==  Bits.at(4, 8))

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

    assert(new LongToBase(StringBits.IS_WHITE).b == Bits.IS_WHITE)
    /*
      TODO adjust with proper assertThrows assertion
      Sign bit throws a java.lang.NumberFormatException:
    assert(new LongToBase(StringBits.CAPTURED).b == Bits.CAPTURED)
     */
    assert(new LongToBase(StringBits.INITIAL_TOP).b ==  Bits.INITIAL_TOP)
    assert(new LongToBase(StringBits.INITIAL_BOT).b ==  Bits.INITIAL_BOT)
    assert(new LongToBase(StringBits.TOP_ROW).b ==  Bits.TOP_ROW)


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
