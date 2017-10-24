/**
 * Handles obstacle movement and initalization.
 * @author Iden Craven
 */
public class GameObstacle extends GameObject {

  public void resetRight(GameScreen screen, GameObstacle obstacle) {
  		obstacle.setX(screen.getScreenWidth() - 3);
  }

  public void moveLeft(GameScreen screen, GameObstacle obstacle) {
  		obstacle.setX(getX() - 1);
  }

  public void moveRight(GameScreen screen, GameObstacle obstacle) {
  		obstacle.setX(getX() + 1);
  }

  public boolean overlapsWith(Frog frog) {
  		for (int i = -1; i < this.getLength(); i++) {
  				if (this.getX() - i == frog.getX() && this.getY() == frog.getY()) {
  						return true;
  				}
  		}
  		return false;
  }
}
