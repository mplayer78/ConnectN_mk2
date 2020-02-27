class Board {
  public static final int BOARD_WIDTH = 7;
  public static final int BOARD_HEIGHT = 6;
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

  // returns the y coordinate of an uninhabited space given the x
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
    // set up coordinate transformations to check for connection
    int[][] cartesian = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
    for (int[] c : cartesian) {
      // each location on the board is checked 4 times, one for each direction
      for (int x = 0; x < BOARD_WIDTH; x++) {
        for (int y = 0; y < BOARD_HEIGHT; y++) {
          if (recursiveCheck(Game.connect, x, y, c[0], c[1])) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean recursiveCheck(int count, int x, int y, int incX, int incY) {
    while (count - 1 > 0) {
      // check if space is not filled
      // if the next space is past the edge
      // if the next square matches the current
      if (x + incX < BOARD_WIDTH && x + incX >= 0 && y + incY < BOARD_HEIGHT && y + incY >= 0 && board[x][y] != 0
          && board[x][y] == board[x + incX][y + incY]) {
        return recursiveCheck(count - 1, x + incX, y + incY, incX, incY);
      }
      return false;
    }
    return true;
  }

}