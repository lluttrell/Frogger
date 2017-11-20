/**
 * Handles construction of a Car object.
 * Inherits from GameObstacle.
 */

public class Car extends GameObstacle {

    //View Constructor
    public Car(int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(xStartingLocation, yStartingLocation, direction, boardWidth);
        setImage("res/asteroid.png");
        getImageDimensions();
        carInit();
    }

    //Text Constructor
    public Car(int width, int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(width, xStartingLocation, yStartingLocation, direction, boardWidth);
        setSymbol('X');
        carInit();
    }

    private void carInit() {
        setDangerous(true);
    }
}
