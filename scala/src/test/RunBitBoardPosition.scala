package test

import logic.board.{Bits, LongToBase}


object RunBitBoardPosition {
  def main(args: Array[String]): Unit = {
    val run = new RunBitBoardPosition
    run.testBits()
    run.boardNumbers()
    run.plainBits()
    run.manipulateBits()
  }
}

class RunBitBoardPosition {
  val Column = Array('a','b','c','d','e','f','g','h')
  val Row = Array('1','2','3','4','5')
  def boardNumbers(): Unit = {
    println("-------------------------------------------------------")
    println("Displays Bit Positioning ")
      for (row <- 0 to 4; col <- 0 to 7) yield {
      println("Position[col,row](" + Column(col) +  "," + Row(row) + ") => " +Bits.at(row, col))
    }
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
