import java.io.*;

class Player {
  protected static int idCounter = 1;
  protected int id;

  public Player() {
    this.assignId();
  }

  protected void assignId() {
    this.id = idCounter;
    idCounter++;
  }

  public int getId() {
    return this.id;
  }

  protected void questionPrompt() {
    Display.log(String.format("Player %d, please enter a number between 1 - %d\n", this.getId(), Board.BOARD_WIDTH));
  }

  public int takeTurn(BufferedReader br) throws Exception {
    questionPrompt();
    // adjust for zero-index
    int input = Integer.parseInt(br.readLine()) - 1;
    return input;
  }
}