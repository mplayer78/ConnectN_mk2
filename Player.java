class Player {
  public static int idCounter = 1;
  private int id;

  public Player() {
    this.id = idCounter;
    idCounter++;
  }

  public int getId() {
    return this.id;
  }
}