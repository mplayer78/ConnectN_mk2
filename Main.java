class Main {
  public static void main(String[] args) {
    Display.log("Welcome to ConnectN");
    // handle command line passing number of connects, defaulting to 4
    String conn = args.length > 0 ? args[0] : "4";
    String human = args.length > 1 ? args[1] : "1";
    String comp = args.length > 2 ? args[2] : "2";
    Game g = new Game(conn, human, comp);
  }
}