import java.awt.event.KeyEvent;

/**
 * Handles the frog.
 * adapted from https://github.com/andreirichkov/console-snake
 */

public class Frog extends GameObject {

	private KeyManager keymanager = new KeyManager();
	private int lives = 3;
	private Board board;

	//text Constructor
	public Frog(char symbol, int xStartingLocation, int yStartingLocation) {
		super(symbol, xStartingLocation, yStartingLocation);
	}

	//GUI constructor
	public Frog(String path, int xStartingLocation, int yStartingLocation, Board board) {
		super(path, xStartingLocation, yStartingLocation);
		this.board = board;
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
	}
}
