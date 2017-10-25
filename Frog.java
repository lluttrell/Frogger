import java.awt.Graphics;

public class Frog extends GameObject {

  private int lives;
  private Game game;

  public Frog(Game game, float x, float y) {
    super(x, y);
    lives = 3;
    this.game = game;
  }

  public void tick() {
    if(game.getKeyManager().up) {
      y -= 3;
    }
  }

  public void render(Graphics g) {
    g.drawImage(Assets.frog, (int) x, (int) y, null);
  }

}
