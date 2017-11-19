/**
 * Handles Construction of Log object
 * Inherits from GameObstacle.
 */
public class Log extends GameObstacle {

    /**
    * GUI constructor
    * @param xStartingLocation Integer representing the x starting location
    * @param xStartingLocation Integer representing the y starting location
    * @param direction char representing the direction of movement 'L' for left
    * 'R' for right.
    * @param boardWidth Integer representing width of the game area
    */
    public Log(int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(xStartingLocation, yStartingLocation, direction, boardWidth);
        if (direction == 'L') {
            setImage("res/shipL.png");
        } else if (direction == 'R') {
            setImage("res/shipR.png");
        }
        getImageDimensions();
    }

    /**
    * Text based constructor
    * @param width Integer representing the number of characters wide the log is
    * @param xStartingLocation Integer representing the x starting location
    * @param xStartingLocation Integer representing the y starting location
    * @param direction char representing the direction of movement 'L' for left
    * 'R' for right.
    * @param boardWidth Integer representing width of the game area
    */
    public Log(int width, int xStartingLocation, int yStartingLocation, char direction, int boardWidth) {
        super(width, xStartingLocation, yStartingLocation, direction, boardWidth);
        setSymbol('L');
    }
}
