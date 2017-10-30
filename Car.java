/**
 * Handles construction of a Car object.
 * Inherits from GameObstacle.
 */

public class Car extends GameObstacle {

  public Car(int xStartingLocation, int yStartingLocation, char direction) {
  	super(xStartingLocation, yStartingLocation, direction);
  	setImage("images/asteroid.png");
  	setSymbol('X');
  	getImageDimensions();
  	setDangerous(true);
  }
}
