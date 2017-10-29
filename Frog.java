import java.awt.event.KeyEvent;

/**
 * Handles the frog.
 * adapted from http://zetcode.com/tutorials/javagamestutorial/collision/
 */

public class Frog extends GameObject {

	private KeyManager keymanager = new KeyManager();
	private int lives = 3;
	private Board board;
	private int startX, startY;

	//GUI constructor
	public Frog(Board board, int xStartingLocation, int yStartingLocation) {
		super(xStartingLocation, yStartingLocation);
		this.board = board;
		startX = xStartingLocation;
		startY = yStartingLocation;
		setImage("images/frog.png");
		setSymbol('F');
		getImageDimensions();
	}

	/**
	 * Handles user input.
	 */
	public void getInput() {
		dx = 0;
		dy = 0;

		if(board.getKeyManager().up) {
			dy -= 1;
		}else if(board.getKeyManager().down) {
			dy += 1;
		}else if(board.getKeyManager().left) {
			dx -= 1;
		}else if(board.getKeyManager().right) {
			dx += 1;
		}
	}

	public void move() {
		super.move();

		if (x < 1) {
			x = 1;
		}

		if (y < 1) {
			y = 1;
		}

		if (x > board.getScreenSize() - 35) {
			x = board.getScreenSize() - 35;
		}

		if (y > board.getScreenSize() - 60) {
			y = board.getScreenSize() - 60;
		}
	}

	public int getLives() {
		return this.lives;
	}

	public void die() {
		this.lives--;
		x = startX;
		y = startY;
	}
}
