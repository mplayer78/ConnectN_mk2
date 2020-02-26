class Board {
  public static int BOARD_WIDTH = 7;
  public static int BOARD_HEIGHT = 6;
  private int[][] board;

  public Board() {
    this.board = new int[BOARD_WIDTH][BOARD_HEIGHT];
  }

  public int getPiece(int x, int y) {
    return board[x][y];
  }

  public void setPiece(int x, int y, int player) {
    board[x][y] = player;
  }

  private int firstFreeSpace(int x) {
    int y = 0;
    while (board[x][y] > 0) {
      y++;
    }
    return y;
  }

  public void takeTurn(int x, int player) {
    setPiece(x, firstFreeSpace(x), player);
  }

  public boolean checkWin() {
    // check horizontal
    // int[][] cartesian = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
    for (int x = 0; x < BOARD_WIDTH; x++) {
      if (recursiveCheck(4, x, 0, 1, 0)) {
        return true;
      }
    }
    return false;
  }

  private boolean recursiveCheck(int count, int x, int y, int incX, int incY) {
    while (count > 1) {
      if (x + incX < BOARD_WIDTH && y + incY < BOARD_HEIGHT && board[x][y] != 0
          && board[x][y] == board[x + incX][y + incY]) {
        System.out.println("TRUE");
        System.out.printf("x = %d, x+1 = %d", x, x + incX);
        recursiveCheck(count - 1, x + incX, y + incY, incX, incY);
      }
      return false;
    }
    System.out.println("BIG TRUE");
    return true;
  }

}