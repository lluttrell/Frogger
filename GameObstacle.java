import java.awt.Graphics;

/**
 * Handles obstacle movement and initalization.
 * @author Iden Craven
 */
public class GameObstacle extends GameObject {

  protected boolean dangerous;
  protected char direction;
  protected final int DEFAULT_SPEED = 1;
  protected final int BOARD_WIDTH = 480;

  //GUI constructor
  public GameObstacle(int xStartingLocation, int yStartingLocation, char direction) {
  	super(xStartingLocation, yStartingLocation);
    this.direction = direction;
  }

  public void move() {
    if (direction == 'L') {
      x -= DEFAULT_SPEED;

    	if (x < 0) {
    		x = BOARD_WIDTH;
    	}
    } else if (direction == 'R') {
      x += DEFAULT_SPEED;

    	if (x > BOARD_WIDTH) {
    		x = 0;
    	}
    }
  }

  /*public boolean overlapsWith(Frog frog) {
  	for (int i = -1; i < this.getLength(); i++) {
  		if (this.getX() - i == frog.getX() && this.getY() == frog.getY()) {
  			return true;
  		}
  	}
  	return false;
  }*/

  //Getters

  public boolean isDangerous() {
  	return dangerous;
  }

  public char getDirection() {
    return direction;
  }

  //Setters

  public void setDangerous(boolean dangerous) {
  	this.dangerous = dangerous;
  }

  public void setDirection(char direction) {
    this.direction = direction;
  }
}
