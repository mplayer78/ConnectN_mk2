import java.io.*;
import java.util.*;

class Game {
  Board board;
  ArrayList<Player> playerList;
  private int turn = 0;
  public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private boolean gameRunning = false;

  public Game() {
    this.board = new Board();
    this.playerList = new ArrayList<Player>();
    Player p1 = new Player();
    Player p2 = new Player();
    playerList.add(p1);
    playerList.add(p2);
    gameRunning = true;
    while (gameRunning) {
      Player currentPlayer = playerList.get(turn % 2);
      System.out.println("Player " + currentPlayer.getId() + " your go.");
      try {
        // adjust for zero-index
        int input = Integer.parseInt(br.readLine()) - 1;
        System.out.println(input);
        board.takeTurn(input, currentPlayer.getId());
        if (board.checkWin()) {
          System.out.printf("Well done!");
        }
        turn++;
        displayBoard();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public void displayBoard() {
    for (int y = Board.BOARD_HEIGHT - 1; y >= 0; y--) {
      System.out.printf("\n");
      for (int x = 0; x < Board.BOARD_WIDTH; x++) {
        System.out.printf("| %d ", this.board.getPiece(x, y));
      }
    }
    System.out.printf("\n");
  }
}