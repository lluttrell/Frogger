public class Log extends GameObstacle {

  public Log(int xStartingLocation, int yStartingLocation, char direction) {
		super(xStartingLocation, yStartingLocation, direction);
		setImage("images/ship1.png");
    setSymbol('L');
	}
}
