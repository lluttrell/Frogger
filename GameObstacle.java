import java.awt.Graphics;

/**
 * Handles obstacle movement and initalization.
 * @author Iden Craven
 */
public class GameObstacle extends GameObject {

  protected boolean dangerous;
  protected boolean vis;
  protected final int DEFAULT_SPEED = 1;
  protected final int BOARD_WIDTH = 480;

  //text constructor
  public GameObstacle(char symbol, int xStartingLocation, int yStartingLocation) {
    super(symbol, xStartingLocation, yStartingLocation);
    vis = true;
  }

  //GUI constructor
  public GameObstacle(int xStartingLocation, int yStartingLocation) {
    super(xStartingLocation, yStartingLocation);
    vis= true;
  }

  public void moveRight() {
    x += DEFAULT_SPEED;

    if (x > BOARD_WIDTH) {
      x = 0;
    }
  }

  public void moveLeft() {
    x -= DEFAULT_SPEED;

    if (x < BOARD_WIDTH) {
      x = BOARD_WIDTH;
    }
  }

  /*public void resetRight(GameScreen screen, GameObstacle obstacle) {
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
  }*/

  //Getters

  public boolean isVisible() {
    return vis;
  }

  public boolean isDangerous() {
  	return dangerous;
  }

  //Setters

  public void setDangerous(boolean dangerous) {
		this.dangerous = dangerous;
	}

  public void setVisible(Boolean vis) {
    this.vis = vis;
  }
}
