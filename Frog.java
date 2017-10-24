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
	}

	public void moveLeft(GameScreen screen, Frog frog) {
		frog.setX(getX() - 1);
		screen.setObjectOnLocation(frog, frog.getX(), frog.getY());
		screen.ClearScreenLocation(frog.getX() + 1, frog.getY(), '*');
	}

	public void moveRight(GameScreen screen, Frog frog) {
		frog.setX(getX() + 1);
		screen.setObjectOnLocation(frog, frog.getX(), frog.getY());
		screen.ClearScreenLocation(frog.getX() - 1, frog.getY(), '*');
	}

	public void moveUp(GameScreen screen, Frog frog) {
		frog.setY(getY() - 1);
		screen.setObjectOnLocation(frog, frog.getX(), frog.getY());
		screen.ClearScreenLocation(frog.getX(), frog.getY() + 1, '*');
	}

	public void moveDown(GameScreen screen, Frog frog) {
		frog.setY(getY() + 1);
		screen.setObjectOnLocation(frog, frog.getX(), frog.getY());
		screen.ClearScreenLocation(frog.getX(), frog.getY() - 1, '*');
	}

	public int getLives() {
		return this.lives;
	}

	public void die() {
		this.lives--;
	}
}
