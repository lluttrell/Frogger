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

    /**
    * GUI Constructor
    * @param xStartingLocation Integer representing initial x position
    * @param yStartingLocation Integer representing initial y position
    * @param direction 'L' for objects moving left 'R' for objects moving
    * @param boardWidth Integer representing width of board
    */
    public GameObstacle(int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(xStartingLocation, yStartingLocation);
        this.direction = direction;
        offScreenBuffer = -120;
        this.boardWidth = boardWidth;
    }

    /**
    * Text Constructor
    * @param width Integer representing with of obstacle (number of characters wide)
    * @param xStartingLocation Integer representing initial x position
    * @param yStartingLocation Integer representing initial y position
    * @param direction 'L' for objects moving left 'R' for objects moving
    * @param boardWidth Integer representing width of board
    */
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
    /**
    * Returns boolean value representing if the object is dangerous to the frog
    * @return true if GameObstacle is dangerous, false otherwise.
    */
    public boolean isDangerous() {
      return dangerous;
    }

    /**
    * Returns character representing the direction of movement of the obstacle
    * @return 'L' for obstacles moving left. 'R' for obstacles moving right
    */
    public char getDirection() {
      return direction;
    }

    /**
    * Returns the speed of the GameObstacle
    * @return Integer representing the speed of the GameObstacle
    */
    public int getSpeed() {
      return DEFAULT_SPEED;
    }

    //Setters
    /**
    * Sets the danger level of the obstacle
    * @param dangerous true if object is dangerous to frog, false otherwise
    */
    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

}
