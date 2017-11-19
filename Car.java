/**
 * Handles construction of a Car object.
 * Inherits from GameObstacle.
 */

public class Car extends GameObstacle {

  /**
  * GUI constructor
  * @param xStartingLocation Integer representing the x starting location
  * @param xStartingLocation Integer representing the y starting location
  * @param direction char representing the direction of movement 'L' for left
  * 'R' for right.
  * @param boardWidth Integer representing width of the game area
  */
    public Car(int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(xStartingLocation, yStartingLocation, direction, boardWidth);
        setImage("res/asteroid.png");
        getImageDimensions();
        carInit();
    }

    /**
    * Text based constructor
    * @param width Integer representing the number of characters wide the car is
    * @param xStartingLocation Integer representing the x starting location
    * @param xStartingLocation Integer representing the y starting location
    * @param direction char representing the direction of movement 'L' for left
    * 'R' for right.
    * @param boardWidth Integer representing width of the game area
    */
    public Car(int width, int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(width, xStartingLocation, yStartingLocation, direction, boardWidth);
        setSymbol('X');
        carInit();
    }

    private void carInit() {
        setDangerous(true);
    }
}
