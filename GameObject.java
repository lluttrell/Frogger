import java.awt.*;

/**
 * Handles Game objects in the game.
 * Parent to Frog and GameObstacles.
 * Adapted from https://github.com/andreirichkov/console-snake
 */

public class GameObject {

    //Instance variables.
    protected int x, y;
    protected int width;
    protected int height;
    protected char symbol;
    protected Image image;

    /**
     * Constructor for GUI version. Takes an image path to represent the object.
     */
    public GameObject(int xStartingLocation, int yStartingLocation) {
        setX(xStartingLocation);
        setY(yStartingLocation);
    }

    // Getters

    public int getX() {
        return x;
    }

    public void setX(int newLocation) {
        x = newLocation;
    }

    public int getY() {
        return y;
    }

    public void setY(int newLocation) {
        y = newLocation;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }

    // Setters

    public Image getImage() {
        return image;
    }

    public void setImage(String path) {
        image = ImageLoader.loadImage(path);
    }

    /**
     * sets game objects width and height to the image size.
     */
    public void getImageDimensions() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
