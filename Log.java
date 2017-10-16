/**
 * Handles log movement and initalization.
 * @author Iden Craven
 */

public class Log extends GameObject {

  private int length;

  public int getLength() {
  		return this.length;
  }

  public Log(int length, int startingX, int startingY) {
  		setSymbol('L');
  		setX(startingX);
  		setY(startingY);
  		this.length = length;
  }

  public void resetRight(GameScreen screen, Log log, Wall wall) {
  		for (int i = -1; i < log.getLength(); i++) {
  				screen.ClearScreenLocation(getX() - i, log.getY());
  		}
  		log.setX(screen.getScreenWidth() - 3);
  		log.initLog(screen,log);
  		//redraw wall
  		screen.setObjectOnLocation(wall, 0, log.getY());
  }

  public void initLog(GameScreen screen, Log log) {
  		for (int i = getX() - 1; i < (getX() - 1) + this.length; i++) {
  				screen.setObjectOnLocation(log, i, log.getY());
  		}
  }

  public void moveLeft(GameScreen screen, Log log) {
  		log.setX(getX() - 1);
  		for (int i = getX() - 1; i < (getX() - 1) + this.length; i++) {
  				screen.setObjectOnLocation(log, i, log.getY());
  		}
  		screen.ClearScreenLocation(log.getX() + 2, log.getY());
  }

  public void moveRight(GameScreen screen, Log log) {
  		log.setX(getX() + 1);
  		for (int i = getX() + 1; i > (getX() + 1) - this.length; i--) {
  				screen.setObjectOnLocation(log, i, log.getY());
  		}
  		screen.ClearScreenLocation(log.getX() - 2, log.getY());
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
