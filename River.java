public class River extends GameObstacle{

	public River(int y) {
		setSymbol('^');
    setLength(super.getScreenWidth()-1);
    setX(super.getScreenWidth()/2-1);
    setY(y);
    setDangerous(true);
	}
  // override the move method so they remain still.
  public void moveLeft(GameObstacle obstacle) {
  }

  public void moveRight(GameObstacle obstacle) {
  }
}
