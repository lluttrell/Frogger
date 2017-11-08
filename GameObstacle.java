/**
 * Handles obstacle movement and initialization.
 * Inherits from GameObject.
 * Parent to Log and Car.
 */
public class GameObstacle extends GameObject {

    private final int DEFAULT_SPEED = 1;
    private boolean dangerous;
    protected char direction;

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

    public void move(int boardWidth) {
        if (direction == 'L') {
            x -= DEFAULT_SPEED;

            if (x < boardWidth - (boardWidth - 3)) {
                x = boardWidth - 3;
            }
        } else if (direction == 'R') {
            x += DEFAULT_SPEED;

            if (x > boardWidth - 2) {
                x = 1;
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
