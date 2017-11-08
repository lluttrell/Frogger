/**
 * Handles Construction of Log object
 * Inherits from GameObstacle.
 */
public class Log extends GameObstacle {

    //GUI constructor
    public Log(int xStartingLocation, int yStartingLocation, char direction) {
        super(xStartingLocation, yStartingLocation, direction);
        if (direction == 'L') {
            setImage("images/shipL.png");
        } else if (direction == 'R') {
            setImage("images/shipR.png");
        }
        getImageDimensions();
    }

    //Text constructor
    public Log(int width, int xStartingLocation, int yStartingLocation, char direction) {
        super(width, xStartingLocation, yStartingLocation, direction);
        setSymbol('L');
    }
}
