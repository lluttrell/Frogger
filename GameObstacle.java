/**
 * Handles obstacle movement and initialization.
 * Inherits from GameObject.
 * Parent to Log and Car.
 */
public class GameObstacle extends GameObject {
    private final int DEFAULT_SPEED = 1;
    private int boardWidth;
    private int offScreenBuffer;
    private boolean dangerous;
    private char direction;

    //View constructor
    public GameObstacle(int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(xStartingLocation, yStartingLocation);
        this.direction = direction;
        offScreenBuffer = -120;
        this.boardWidth = boardWidth;
    }

    //Text Constructor
    public GameObstacle(int width, int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(width, xStartingLocation, yStartingLocation);
        this.direction = direction;
        this.boardWidth = boardWidth;
        offScreenBuffer = boardWidth - (boardWidth - getWidth());
    }

    /**
     * Handles movement of Game Obstacles.
     */
    public void move() {
        if (getDirection() == 'L') {
            setX(getX() - getSpeed());

            if (getX() < offScreenBuffer - 2) {
                setX(boardWidth - (getWidth() - 1));
            }
        } else if (getDirection() == 'R') {
            setX(getX() + getSpeed());

            if (getX() == boardWidth - 1) {
                setX(1);
            }
        }
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
