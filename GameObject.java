import java.awt.Graphics;

/**
 * Handles setting walls around the GameScreen.
 * adapted from https://github.com/andreirichkov/console-snake
 */

public abstract class GameObject {

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_HEIGHT = 64;

	protected float x, y;
	protected char symbol;
	protected int height;
	protected int length;
	protected float speed;
	protected float xMove, yMove;

	public GameObject(float x, float y, int length) {
		this.x = x;
		this.y = y;
		this.length = length;
		speed = DEFAULT_SPEED;
		height = DEFAULT_HEIGHT;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		x += xMove;
		y += yMove;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	// Getters

	public int getHeight() {
		return this.height;
	}

	public float getXMove() {
		return this.xMove;
	}

	public float getYMove() {
		return this.yMove;
	}

	/**
	 * Returns the x coordinate of the GameObject.
	 * @return x Coordinate of the GameObject
	 */
	public float getX() {
		return x;
	}

	/**
	 * Returns the y coordinate of the GameObject.
	 * @return y Coordinate of the GameObject
	 */
	public float getY() {
		return y;
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

	public void setXMove(float xMove) {
		this.xMove = xMove;
	}

	public void setYMove(float yMove) {
		this.yMove = yMove;
	}

	/**
	 * Sets the x coordinate of the GameObject.
	 * @param newLocation New x coordinate
	 */
	public void setX(float newLocation) {
		x = newLocation;
	}

	/**
	 * Sets the x coordinate of the GameObject.
	 * @param newLocation New y coordinate
	 */
	public void setY(float newLocation) {
		y = newLocation;
	}

	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Sets the text character used to draw the GameObject.
	 * @param newSymbol New character
	 */
	public void setSymbol(char newSymbol) {
		symbol = newSymbol;
	}
}
