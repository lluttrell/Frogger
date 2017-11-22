package frogger;

/**
 * Handles construction of a frogger.Car object.
 * Inherits from frogger.GameObstacle.
 */

public class Car extends GameObstacle {

    /**
     * GUI constructor
     *
     * @param xStartingLocation Integer representing the x starting location
     * @param yStartingLocation Integer representing the y starting location
     * @param direction         char representing the direction of movement 'L' for left
     *                          'R' for right.
     * @param boardWidth        Integer representing width of the game area
     */
    public Car(int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(xStartingLocation, yStartingLocation, direction, boardWidth);
        setImage("/images/asteroid.png");
        getImageDimensions();
        carInit();
    }

    /**
     * Text based constructor
     *
     * @param width             Integer representing the number of characters wide the car is
     * @param xStartingLocation Integer representing the x starting location
     * @param yStartingLocation Integer representing the y starting location
     * @param direction         char representing the direction of movement 'L' for left
     *                          'R' for right.
     * @param boardWidth        Integer representing width of the game area
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
