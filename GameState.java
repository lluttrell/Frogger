import java.awt.Graphics;

/**
 * The default state for the game. Inherits from State.
 */
public class GameState extends State {

  private Frog frog;

  /**
   * Default constructor.
   * runs the game object and creates a new Frog object.
   * @param game a game object that houses the main game logic and loop.
   */
  public GameState(Game game) {
    super(game);
    frog = new Frog(game, 100, 100, 64);
  }

  public void tick() {
    frog.tick();
  }

  public void render(Graphics g) {
    frog.render(g);
    Tile.tiles[0].render(g, 0, 0);
  }
}
