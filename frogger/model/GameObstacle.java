package frogger.model;

/**
 * Handles obstacle movement and initialization.
 * Inherits from GameObject.
 */
public class GameObstacle extends GameObject {
    private final int DEFAULT_SPEED = 1;
    private final int boardWidth;
    private final int offScreenBuffer;
    private boolean dangerous;
    private char direction;

    /**
     * GUI Constructor
     *
     * @param xStartingLocation Integer representing initial x position
     * @param yStartingLocation Integer representing initial y position
     * @param direction         'L' for objects moving left 'R' for objects moving
     * @param boardWidth        Integer representing width of board
     */
    public GameObstacle(int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(xStartingLocation, yStartingLocation);
        this.direction = direction;
        offScreenBuffer = -120;
        this.boardWidth = boardWidth;
    }

    /**
     * Text Constructor
     *
     * @param width             Integer representing with of obstacle (number of characters wide)
     * @param xStartingLocation Integer representing initial x position
     * @param yStartingLocation Integer representing initial y position
     * @param direction         'L' for objects moving left 'R' for objects moving
     * @param boardWidth        Integer representing width of board
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
        if (direction == 'L') {
            x -= DEFAULT_SPEED;

            if (x < offScreenBuffer - 2) {
                x = (boardWidth - (width - 1));
            }
        } else if (direction == 'R') {
            x += DEFAULT_SPEED;

            if (x >= boardWidth - 1) {
                x = 1;
            }
        }
    }

    //Getters

    /**
     * Returns boolean value representing if the object is dangerous to the frog
     *
     * @return true if GameObstacle is dangerous, false otherwise.
     */
    public boolean isDangerous() {
        return dangerous;
    }

    /**
     * Returns character representing the direction of movement of the obstacle
     *
     * @return 'L' for obstacles moving left. 'R' for obstacles moving right
     */
    public char getDirection() {
        return direction;
    }

    //Setters

    /**
     * Sets the danger level of the obstacle
     *
     * @param dangerous true if object is dangerous to frog, false otherwise
     */
    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }
}
