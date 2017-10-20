/**
 * Handles obstical movement and initalization.
 * @author Iden Craven
 */
public class GameObstacle extends GameObject {

  private int length;

  public void resetRight(GameScreen screen, GameObstacle obstical, Wall wall) {
  		for (int i = -1; i < obstical.getLength(); i++) {
  				screen.ClearScreenLocation(getX() - i, obstical.getY());
  		}
  		obstical.setX(screen.getScreenWidth() - 3);
  		obstical.initObstacle(screen,obstical);
  		//redraw wall
  		screen.setObjectOnLocation(wall, 0, obstical.getY());
  }

  public void initObstacle(GameScreen screen, GameObstacle obstical) {
  		for (int i = getX() - 1; i < (getX() - 1) + this.length; i++) {
  				screen.setObjectOnLocation(obstical, i, obstical.getY());
  		}
  }

  public void moveLeft(GameScreen screen, GameObstacle obstical) {
  		obstical.setX(getX() - 1);
  		for (int i = getX() - 1; i < (getX() - 1) + this.length; i++) {
  				screen.setObjectOnLocation(obstical, i, obstical.getY());
  		}
  		screen.ClearScreenLocation(obstical.getX() + 2, obstical.getY());
  }

  public void moveRight(GameScreen screen, GameObstacle obstical) {
  		obstical.setX(getX() + 1);
  		for (int i = getX() + 1; i > (getX() + 1) - this.length; i--) {
  				screen.setObjectOnLocation(obstical, i, obstical.getY());
  		}
  		screen.ClearScreenLocation(obstical.getX() - 2, obstical.getY());
  }

  public boolean overlapsWith(Frog frog) {
  		for (int i = -1; i < this.getLength(); i++) {
  				if (this.getX() - i == frog.getX() && this.getY() == frog.getY()) {
  						return true;
  				}
  		}
  		return false;
  }

  public void setLength(int length) {
  		this.length = length;
  }

  public int getLength() {
  		return this.length;
  }
}
