public class Log extends GameObstacle {

  public Log(int xStartingLocation, int yStartingLocation, char direction) {
		super(xStartingLocation, yStartingLocation, direction);
    initLog();
	}

  public void initLog() {
    if (direction == 'L') {
      setImage("images/shipL.png");
    } else if (direction == 'R') {
      setImage("images/shipR.png");
    }
    setSymbol('L');
  }
}
