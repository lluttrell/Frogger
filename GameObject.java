import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * Handles setting walls around the GameScreen.
 * Adapted from https://github.com/andreirichkov/console-snake
 */

public class GameObject {

	//Instance variables.
	protected int dx, dy;
	protected int x, y;
	protected int width;
  protected int height;
	protected char symbol;
	protected boolean dangerous;
	protected Image image;

	/**
	 * Constructor for text version. Takes a char for the objects symbol.
	 */
	public GameObject(char symbol, int xStartingLocation, int yStartingLocation) {
		setSymbol(symbol);
		setX(xStartingLocation);
		setY(yStartingLocation);
	}

	/**
	 * Constructor for GUI version. Takes an image path to represent the object.
	 */
	public GameObject(int xStartingLocation, int yStartingLocation) {
		setX(xStartingLocation);
		setY(yStartingLocation);
	}

	public void move() {
		x += dx;
		y += dy;
	}

	// Getters

	public int getX() {
		return this.x;
	}

	public int getY() {
		return y;
	}

	public boolean isDangerous() {
		return dangerous;
	}

	public char getSymbol() {
		return symbol;
	}

	public Image getImage() {
		return image;
	}

	public void getImageDimensions() {
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	// Setters

	public void setX(int newLocation) {
		x = newLocation;
	}

	public void setY(int newLocation) {
		y = newLocation;
	}

	public void setDangerous(boolean dangerous) {
		this.dangerous = dangerous;
	}

	/**
	 * Sets the text character used to draw the GameObject.
	 * @param newSymbol New character
	 */
	public void setSymbol(char newSymbol) {
		symbol = newSymbol;
	}

	public void setImage(String path) {
		image = ImageLoader.loadImage(path);
	}
}
