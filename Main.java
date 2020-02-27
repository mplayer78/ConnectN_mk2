class Main {
  public static void main(String[] args) {
    Display.log("Welcome to ConnectN");
    // handle command line passing number of connects, defaulting to 4
    String arg = args.length > 0 ? args[0] : "4";
    Game g = new Game(arg);
  }
}