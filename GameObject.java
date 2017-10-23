/**
 * Handles setting walls around the GameScreen.
 * @author andreirichkov
 * retrieved from https://github.com/andreirichkov/console-snake
 */

public class GameObject {

	private int x, y;
	private char symbol;
	private int length;

	// Getters
	/**
	* Returns the x coordinate of the GameObject.
	* @return x Coordinate of the GameObject
	*/
	public int getX() {
		return this.x;
	}

	/**
	* Returns the y coordinate of the GameObject.
	* @return y Coordinate of the GameObject
	*/
	public int getY() {
		return this.y;
	}

	/**
	* Returns the character used to represent the GameObject
	* @return char used to represent the GambeObject
	*/
	public char getSymbol() {
		return symbol;
	}

	public int getLength() {
		return length;
	}

	// Setters
	/**
	* Sets the x coordinate of the GameObject.
	* @param newLocation New x coordinate
	*/
	public void setX(int newLocation) {
		this.x = newLocation;
	}

	/**
	* Sets the x coordinate of the GameObject.
	* @param newLocation New y coordinate
	*/
	public void setY(int newLocation) {
		this.y = newLocation;
	}

	public void setLength(int length) {
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
