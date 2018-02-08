package logic.board

import scala.language.postfixOps

/**
  * This object is not used in the program
  * It is only provided for educational purposes
  * and documentation
  */
object StringBits {

  val S = '_' // byte separator

  val IS_WHITE    ="01000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000".filterNot(S==)
  val CAPTURED    ="10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000".filterNot(S==)

  /*
        Capture Color                INITIAL_TOP
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
  val INITIAL_TOP ="00000000_00000001_11111111_01111111_11010100_10100000_00000000_00000000".filterNot(S==)
  //                    ^ Group 0  ^ _Group 1  ^ Group 2  ^ Group 3  ^ Group 4  ^ Group 5

  /*
          Capture	Color									INITIAL_BOT
              ^ ^
    Top Four	0	1	2	3  (4 specialized bits)
              0 0 0 0

    Groups	0	1	2	3	4	5	6	7	8	9
    0       0	0	0	0	0	0	0	0	0	0	Empty Group
    1       0	0	0	0	0	0	0	0	0	0	Empty Group
    2       0	0	0	0	0	0	0	0	0	0	Empty Group
    3       0	0	1	0	1	0	0	1	0	1
    4       0	1	1	1	1	1	1	1	1	1
    5       0	1	1	1	1	1	1	1	1	1
    Empty First Column
  */
  val INITIAL_BOT ="00000000_00000000_00000000_00000000_00001010_01010111_11111101_11111111".filterNot(S==)
  //                    ^ Group 0  ^ _Group 1  ^ Group 2  ^ Group 3  ^ Group 4  ^ Group 5

  /*
        Capture	Color									TOP_ROW
              ^ ^
    Top Four	0	1	2	3  (4 specialized bits)
              0 0 0 0

    Groups	0	1	2	3	4	5	6	7	8	9
    0       0	0	0	0	0	0	0	0	0	0	Empty Group
    1       0	1	1	1	1	1	1	1	1	1
    2       0	0	0	0	0	0	0	0	0	0	Empty Group
    3       0	0	0	0	0	0	0	0	0	0	Empty Group
    4       0	0	0	0	0	0	0	0	0	0	Empty Group
    5       0	0	0	0	0	0	0	0	0	0	Empty Group
    Empty First Column
  */
  val TOP_ROW     ="00000000_00000001_11111111_00000000_00000000_00000000_00000000_00000000".filterNot(S==)
  //                    ^ Group 0  ^ _Group 1  ^ Group 2  ^ Group 3  ^ Group 4  ^ Group 5

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

