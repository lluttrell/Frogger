import java.awt.Graphics;

/**
 * Handles obstacle movement and initalization.
 * @author Iden Craven
 */
public class GameObstacle extends GameObject {

  protected boolean dangerous;
  protected int width;
  protected int height;

  public GameObstacle(char symbol, int xStartingLocation, int yStartingLocation, int width, int height) {
    super(symbol, xStartingLocation, yStartingLocation);
    this.width = width;
    this.height = height;
  }

  public GameObstacle(String path, int xStartingLocation, int yStartingLocation, int width, int height) {
    super(path, xStartingLocation, yStartingLocation);
    this.width = width;
    this.height = height;
  }

  public void resetRight(GameScreen screen, GameObstacle obstacle) {
  	obstacle.setX(screen.getScreenWidth() - 3);
  }

  public void moveLeft(GameObstacle obstacle) {
  	obstacle.setX(getX() - 1);
  }

  public void moveRight(GameObstacle obstacle) {
  	obstacle.setX(getX() + 1);
  }

  public void moveObstacle(GameScreen screen, GameObstacle obstacle) {
  	int width = screen.getScreenWidth();
  	if (obstacle.getX() > width - (width -2)) {
  		obstacle.moveLeft(obstacle);
  	} else {
  		obstacle.resetRight(screen,obstacle);
  	}
  }

  public boolean overlapsWith(Frog frog) {
  	for (int i = -1; i < this.getLength(); i++) {
  		if (this.getX() - i == frog.getX() && this.getY() == frog.getY()) {
  			return true;
  		}
  	}
  	return false;
  }

  public void setDangerous(boolean dangerous) {
		this.dangerous = dangerous;
	}

  public boolean isDangerous() {
  	return dangerous;
  }
}
