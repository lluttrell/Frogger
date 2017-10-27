import java.awt.Graphics;

/**
 * Frog handles the player of the game and their input. Inherits from GameObject.
 */
public class Frog extends GameObject {

  public static final int DEFAULT_LIVES = 3;

  protected int lives;
  private Game game;

  /**
   * Default constructor.
   * Calls parent GameObject class,
   * @param game object to which the frog belongs to.
   * @param x the frog's x co-ordinate on the screen.
   * @param y the frog's y co-ordinate on the screen.
   * @param length the frog's length.
   */
  public Frog(Game game, float x, float y, int length) {
    super(x, y, length);
    lives = DEFAULT_LIVES;
    this.game = game;
  }

  public void tick() {
    getInput();
    move();
  }

  /**
   * Handles user input.
   */
  private void getInput() {
    xMove = 0;
    yMove = 0;

    if(game.getKeyManager().up) {
      yMove = -speed;
    }else if(game.getKeyManager().down) {
      yMove = speed;
    }else if(game.getKeyManager().left) {
      xMove = -speed;
    }else if(game.getKeyManager().right) {
      xMove = speed;
    }
  }

  public void render(Graphics g) {
    g.drawImage(Assets.frog, (int) x, (int) y, length, height, null);
  }

}
