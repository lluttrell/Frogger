import java.awt.Graphics;

/**
 * Handles setting walls around the GameScreen.
 * adapted from https://github.com/andreirichkov/console-snake
 */

public abstract class GameObject {

	protected float x, y;
	protected char symbol;
	protected float length;
	protected boolean dangerous;

	public GameObject(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	// Getters
	/**
	 * Returns the x coordinate of the GameObject.
	 * @return x Coordinate of the GameObject
	 */
	public float getX() {
			return this.x;
	}

	/**
	 * Returns the y coordinate of the GameObject.
	 * @return y Coordinate of the GameObject
	 */
	public float getY() {
			return this.y;
	}

	public boolean isDangerous() {
			return dangerous;
	}

	/**
	 * Returns the character used to represent the GameObject
	 * @return char used to represent the GambeObject
	 */
	public char getSymbol() {
			return symbol;
	}

	public float getLength() {
			return length;
	}

	// Setters
	/**
	 * Sets the x coordinate of the GameObject.
	 * @param newLocation New x coordinate
	 */
	public void setX(float newLocation) {
			this.x = newLocation;
	}

	/**
	 * Sets the x coordinate of the GameObject.
	 * @param newLocation New y coordinate
	 */
	public void setY(float newLocation) {
			this.y = newLocation;
	}

	public void setDangerous(boolean dangerous) {
			this.dangerous = dangerous;
	}

	public void setLength(float length) {
			this.length = length;
	}

	/**
	 * Sets the text character used to draw the GameObject.
	 * @param newSymbol New character
	 */
	public void setSymbol(char newSymbol) {
			this.symbol = newSymbol;
	}
}
