/**
 * Handles obstacle movement and initialization.
 * Inherits from GameObject.
 * Parent to Log and Car.
 */
public class GameObstacle extends GameObject {

    private final int DEFAULT_SPEED = 1;
    private final int BOARD_WIDTH = 480;
    private boolean dangerous;
    protected char direction;

    //GUI constructor
    public GameObstacle(int xStartingLocation, int yStartingLocation, char direction) {
        super(xStartingLocation, yStartingLocation);
        this.direction = direction;
    }

    public void move() {
        if (direction == 'L') {
            x -= DEFAULT_SPEED;

            if (x < -120) {
                x = BOARD_WIDTH;
            }
        } else if (direction == 'R') {
            x += DEFAULT_SPEED;

            if (x > BOARD_WIDTH) {
                x = 0;
            }
        }
    }

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
