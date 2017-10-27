import java.awt.Graphics;

/**
 * Abstract class for the game's different states. Used for menus
 * and possibly text-based version.
 */
public abstract class State {

  private static State currentState = null;

  /**
   * Setter for state object
   * @param state state to set currentState to
   */
  public static void setState(State state) {
    currentState = state;
  }

  /**
   * Getter for state object
   */
  public static State getState() {
    return currentState;
  }

  //CLASS
  protected Game game;

  public State(Game game) {
    this.game = game;
  }

  public abstract void tick();

  public abstract void render(Graphics g);

}
