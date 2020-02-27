import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.*;

class ComputerPlayer extends Player {
  Random rand = new Random();

  public ComputerPlayer() {
    // inherit assign id inherited from player
  }

  @Override
  public int takeTurn(BufferedReader br) throws Exception {
    this.questionPrompt();
    int randomGuess = rand.nextInt(Board.BOARD_WIDTH);
    // no time delay gives a confusing user experience to humanised computer turns
    // with time delay
    TimeUnit.MILLISECONDS.sleep(200);
    Display.log(Integer.toString(randomGuess + 1));
    return randomGuess;
  }
}