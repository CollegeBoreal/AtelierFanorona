package test

import logic.board.Bits


object RunBitBoardPosition {
  def main(args: Array[String]): Unit = {
    val run = new RunBitBoardPosition
    run.testBits()
    run.boardNumbers()
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

  def testBits(): Unit = {
    val myPieces = Bits.INITIAL_BOT | Bits.IS_WHITE
    val opponentPieces = Bits.INITIAL_TOP
    println("myPieces: " + myPieces + " opponentPieces: " + opponentPieces)
    println("-------------------------------------------------------")
    println("Displays in HEX ")
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


    println("-------------------------------------------------------")
    println("Displays in DECIMAL ")
    println("INITIAL_TOP	: " + 562399469895680L)
    println("INITIAL_BOT	: " + 173538815L)
    println("TOP_ROW		: " + 561850441793536L)
    println("BOTTOM_ROW	: " + 511L)
    println("LEFT_COL	: " + 281750123315456L)
    println("RIGHT_COL	: " + 1100586419201L)
    println("DIAGONAL	: " + 375116358920533L)
    println("ON_BOARD	: " + 562399660211711L)
    println("CENTER		: " + 130023424L)
  }

}
