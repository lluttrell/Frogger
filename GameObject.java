import java.awt.*;

/**
 * Handles Game objects in the game.
 * Parent to Frog and GameObstacles.
 * Adapted from https://github.com/andreirichkov/console-snake
 */

public class GameObject {

    //Instance variables.
    protected int x, y;
    private int width;
    private int height;
    private char symbol;
    private Image image;

    /**
     * Constructor.
     */
    public GameObject(int xStartingLocation, int yStartingLocation) {
        setX(xStartingLocation);
        setY(yStartingLocation);
    }

    // Getters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * sets game objects width and height to the image size.
     */
    public void getImageDimensions() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public char getSymbol() {
        return symbol;
    }

    //Setters

    public void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }

    public void setX(int newLocation) {
        x = newLocation;
    }

    public void setY(int newLocation) {
        y = newLocation;
    }

    public void setWidth(int newWidth) {
        width = newWidth;
    }

    public void setImage(String path) {
        image = ImageLoader.loadImage(path);
    }

}
