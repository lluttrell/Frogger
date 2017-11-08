/**
 * Handles Construction of Log object
 * Inherits from GameObstacle.
 */
public class Log extends GameObstacle {

    //GUI constructor
    public Log(int xStartingLocation, int yStartingLocation, char direction) {
        super(xStartingLocation, yStartingLocation, direction);
        initLog();
        getImageDimensions();
    }

    //Text constructor
    public Log(int width, int xStartingLocation, int yStartingLocation, char direction) {
        super(width, xStartingLocation, yStartingLocation, direction);
        initLog();
    }

    private void initLog() {
        if (direction == 'L') {
            setImage("images/shipL.png");
        } else if (direction == 'R') {
            setImage("images/shipR.png");
        }
        setSymbol('L');
    }
}
