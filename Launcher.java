/**
 * Launcher simply creates an instance of the game and launches it.
 */

public class Launcher {
  public static void main(String[] args) {
    Game game = new Game("Frogger", 640, 360);
    game.start();
  }
}
