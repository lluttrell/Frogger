package frogger;

/**
 * Handles Construction of frogger.Platform object
 * Inherits from frogger.GameObstacle.
 */
public class Platform extends GameObstacle {

    /**
     * frogger.graphics.view.View constructor
     *
     * @param xStartingLocation Integer representing the x starting location
     * @param yStartingLocation Integer representing the y starting location
     * @param direction         char representing the direction of movement 'L' for left
     *                          'R' for right.
     * @param boardWidth        Integer representing width of the game area
     */
    public Platform(int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(xStartingLocation, yStartingLocation, direction, boardWidth);
        if (direction == 'L') {
            setImage("/images/shipL.png");
        } else if (direction == 'R') {
            setImage("/images/shipR.png");
        }
        getImageDimensions();
    }

    /**
     * Text based constructor
     *
     * @param width             Integer representing the number of characters wide the log is
     * @param xStartingLocation Integer representing the x starting location
     * @param yStartingLocation Integer representing the y starting location
     * @param direction         char representing the direction of movement 'L' for left
     *                          'R' for right.
     * @param boardWidth        Integer representing width of the game area
     */
    public Platform(int width, int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(width, xStartingLocation, yStartingLocation, direction, boardWidth);
        setSymbol('L');
    }
}
