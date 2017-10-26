import java.awt.Graphics;

public class Frog extends GameObject {

  public static final int DEFAULT_LIVES = 3;

  protected int lives;
  private Game game;

  public Frog(Game game, float x, float y, int length) {
    super(x, y, length);
    lives = DEFAULT_LIVES;
    this.game = game;
  }

  public void tick() {
    getInput();
    move();
  }

  private void getInput() {
    xMove = 0;
    yMove = 0;

    if(game.getKeyManager().up) {
      yMove = -speed;
    }
    if(game.getKeyManager().down) {
      yMove = speed;
    }
    if(game.getKeyManager().left) {
      xMove = -speed;
    }
    if(game.getKeyManager().right) {
      xMove = speed;
    }
  }

  public void render(Graphics g) {
    g.drawImage(Assets.frog, (int) x, (int) y, length, height, null);
  }

}
