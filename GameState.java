import java.awt.Graphics;

public class GameState extends State {

  private Frog frog;

  public GameState(Game game) {
    super(game);
    frog = new Frog(game, 100, 100, 32);
  }

  public void tick() {
    frog.tick();
  }

  public void render(Graphics g) {
    frog.render(g);
  }
}
