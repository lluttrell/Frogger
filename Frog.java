/**
 * Handles setting walls around the GameScreen.
 * @author andreirichkov
 * retrieved from https://github.com/andreirichkov/console-snake
 */

public class Frog extends GameObject {

	private int lives = 3;

	public Frog(char symbol, int xStartingLocation, int yStartingLocation) {
		setSymbol(symbol);
		setX(xStartingLocation);
		setY(yStartingLocation);
		setLength(1);
	}

	public void moveLeft(Frog frog) {
		frog.setX(getX() - 1);
	}

	public void moveRight(Frog frog) {
		frog.setX(getX() + 1);
	}

	public void moveUp(Frog frog) {
		frog.setY(getY() - 1);
	}

	public void moveDown(Frog frog) {
		frog.setY(getY() + 1);
	}

	public int getLives() {
		return this.lives;
	}

	public void die() {
		this.lives--;
	}
}
