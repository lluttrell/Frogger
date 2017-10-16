/**
 * Handles Car movement and initalization.
 * @author Iden Craven
 */

public class Car extends GameObject {

  private int length;

  public int getLength() {
  		return this.length;
  }

  public Car(int length, int startingX, int startingY) {
  		setSymbol('X');
  		setX(startingX);
  		setY(startingY);
  		this.length = length;
  }

  public void resetRight(GameScreen screen, Car car, Wall wall) {
  		for (int i = -1; i < car.getLength(); i++) {
  				screen.ClearScreenLocation(getX() - i, car.getY());
  		}
  		car.setX(screen.getScreenWidth() - 3);
  		car.initCar(screen,car);
  		//redraw wall
  		screen.setObjectOnLocation(wall, 0, car.getY());
  }

  public void initCar(GameScreen screen, Car car) {
  		for (int i = getX() - 1; i < (getX() - 1) + this.length; i++) {
  				screen.setObjectOnLocation(car, i, car.getY());
  		}
  }

  public void moveLeft(GameScreen screen, Car car) {
  		car.setX(getX() - 1);
  		for (int i = getX() - 1; i < (getX() - 1) + this.length; i++) {
  				screen.setObjectOnLocation(car, i, car.getY());
  		}
  		screen.ClearScreenLocation(car.getX() + 2, car.getY());
  }

  public void moveRight(GameScreen screen, Car car) {
  		car.setX(getX() + 1);
  		for (int i = getX() + 1; i > (getX() + 1) - this.length; i--) {
  				screen.setObjectOnLocation(car, i, car.getY());
  		}
  		screen.ClearScreenLocation(car.getX() - 2, car.getY());
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
