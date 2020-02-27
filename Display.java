// display abstracted so that the class could be extended to output to a different media
class Display {
  private static final char[] tokenList = { ' ', 'x', 'o', '#', '*' };

  public static void log(String s) {
    System.out.print(s);
  }

  public static void print(Board board) {
    for (int y = Board.BOARD_HEIGHT - 1; y >= 0; y--) {
      System.out.printf("\n");
      for (int x = 0; x < Board.BOARD_WIDTH; x++) {
        System.out.printf("| %c ", tokenList[board.getPiece(x, y)]);
      }
      System.out.printf("|");
    }
    System.out.printf("\n");

  }
}