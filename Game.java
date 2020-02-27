import java.io.*;
import java.util.*;

class Game {
  Board board;
  ArrayList<Player> playerList;
  private int turn = 0;
  public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private boolean gameRunning = false;
  public static int connect;
  private static int human;
  private static int comp;

  public Game(String connArg, String humanArg, String compArg) {
    this.board = new Board();
    this.playerList = new ArrayList<Player>();
    try {
      connect = Integer.parseInt(connArg);
      human = Integer.parseInt(humanArg);
      comp = Integer.parseInt(compArg);
    } catch (NumberFormatException e) {
      Display.log("\nInvalid command line argument\n");
      System.exit(1);
    }
    for (int i = 0; i < human; i++) {
      Player p1 = new Player();
      playerList.add(p1);
    }
    for (int i = 0; i < comp; i++) {
      Player p2 = new ComputerPlayer();
      playerList.add(p2);
    }
    gameRunning = true;
    while (gameRunning) {
      Player currentPlayer = playerList.get(turn % playerList.size());
      try {
        int turnInt = currentPlayer.takeTurn(br);
        board.takeTurn(turnInt, currentPlayer.getId());
        Display.print(this.board);
        if (board.checkWin()) {
          Display
              .log(String.format("\n*** Well done player %d, you are a worthy winner! ***\n", currentPlayer.getId()));
          gameRunning = false;
        }
        turn++;
      } catch (IndexOutOfBoundsException e) {
        Display.log("Sorry, that's not a valid move. Try again.\n");
      } catch (NumberFormatException e) {
        Display.log(String.format("You need to input a number between 1 - %d, try again.\n", Board.BOARD_WIDTH));
      } catch (Exception e) {
        Display.log(e.getMessage());
      }
    }
  }
}