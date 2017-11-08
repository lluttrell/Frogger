/**
 * Handles construction of a Car object.
 * Inherits from GameObstacle.
 */

public class Car extends GameObstacle {

    //GUI Constructor
    public Car(int xStartingLocation, int yStartingLocation, char direction) {
        super(xStartingLocation, yStartingLocation, direction);
        setImage("images/asteroid.png");
        getImageDimensions();
        carInit();
    }

    //Text Constructor
    public Car(int width, int xStartingLocation, int yStartingLocation, char direction) {
        super(width, xStartingLocation, yStartingLocation, direction);
        setSymbol('X');
        carInit();
    }

    private void carInit() {
        setDangerous(true);
    }
}
