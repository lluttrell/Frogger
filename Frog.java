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

	public int getLives() {
		return this.lives;
	}

	public void die() {
		this.lives--;
		x = startX;
		y = startY;
	}
}
