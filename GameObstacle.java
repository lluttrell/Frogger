/**
 * Handles obstacle movement and initialization.
 * Inherits from GameObject.
 * Parent to Log and Car.
 */
public class GameObstacle extends GameObject {

    private final int DEFAULT_SPEED = 1;
    private boolean dangerous;
    private char direction;

    //GUI constructor
    public GameObstacle(int xStartingLocation, int yStartingLocation, char direction) {
        super(xStartingLocation, yStartingLocation);
        this.direction = direction;
    }

    //Text Constructor
    public GameObstacle(int width, int xStartingLocation, int yStartingLocation, char direction) {
        super(width, xStartingLocation, yStartingLocation);
        this.direction = direction;
    }

    //Getters

    public boolean isDangerous() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    //Setters

    public char getDirection() {
        return direction;
    }

    public int getSpeed() {
        return DEFAULT_SPEED;
    }

}
