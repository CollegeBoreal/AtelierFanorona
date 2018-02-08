
package logic.board

// Game of Fanorona
// David Eppstein, UC Irvine, 11 Jun 1997
//
// Bit manipulation

// We represent Fanorona positions using two bitboards (64-bit longs)
// one for the pieces of each player.  The bits in the bitboard form
// six 10-bit groups: an empty group followed by one for each row of the board.
// Each row has an empty bit followed by a bit for each position in the row.
// The empty bits help avoid extra range checking while finding captures.

// The top four bits are free for other purposes; we use one
// to determine which color pieces are on each side, and one to determine
// whether the side on move's most recent move was a capture.

// This class is not instantiable; instead it consists of constants
// for various board configurations, used in game setup, move generation,
// and evaluation.

object Bits {

  type Board = Long

  val IS_WHITE: Board      = 0x4000000000000000L // 1L << 62
  val CAPTURED: Board      = 0x8000000000000000L // 1L << 63; sign bit speeds tests

  // HEX Annotation
  val INITIAL_TOP: Board   = 0x0001ff7fd4a00000L
  val INITIAL_BOT: Board   = 0x000000000a57fdffL
  val TOP_ROW: Board       = 0x0001ff0000000000L
  val BOTTOM_ROW: Board    = 0x00000000000001ffL
  val LEFT_COL: Board      = 0x0001004010040100L
  val RIGHT_COL: Board     = 0x0000010040100401L
  val DIAGONAL: Board      = 0x0001552a9552a955L
  val ON_BOARD: Board      = 0x0001ff7fdff7fdffL
  val CENTER: Board        = 0x0000000007c00000L

  // turn screen coordinates into bit position
  def at(row: Int, col: Int): Board = 1L << (10 * (4 - row)) + (8 - col)

  // isolate one of the bits from a bitboard
  def lastBit(bitBoard: Long): Board = bitBoard & -bitBoard

  // how much to shift from coordinates
  val SHIFT_VERTICAL = 10
  val SHIFT_HORIZONTAL = 1
  val SHIFT_SLANT = 11
  val SHIFT_BACKSLANT = 9

  // count number of set bits in a word
  private[board] val ONES   = 0x5555555555555555L // A series of 0101 0101 0101 on all 64 bits
  private[board] val TWOS   = 0x3333333333333333L // A series of 0011 0011 0011 on all 64 bits
  private[board] val FOURS  = 0x0f0f0f0f // A series 0f 0000 1111 0000 1111 on only last 32 bits

  def count(set$: Long): Int = {
    // TODO Just not functional
    var set = set$
    set -= (set >>> 1) & ONES
    set = (set & TWOS) + ((set >>> 2) & TWOS)
    val result = set.toInt + (set >>> 32).toInt
    (((result & FOURS) + ((result >>> 4) & FOURS)) * 0x01010101) >>> 24
  }
}

/*
  Must be slow,
  use only for debugging Board Representation
 */
class LongToBase( val digits:String ) extends AnyVal {
  def base(b:Long) = java.lang.Long.parseLong( digits, 2)
  def b = base(2)
  def o = base(8)
  def x = base(16)
}
