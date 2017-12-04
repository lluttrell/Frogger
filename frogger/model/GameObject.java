package frogger.model;

import frogger.util.MediaLoader;

import java.awt.*;

/**
 * Handles Game objects in the game.
 * Parent to Frog and GameObstacle.
 */

public class GameObject {
    //Instance variables.
    protected int x, y;
    protected int width;
    private int height;
    private char symbol;
    private Image image;

    /**
     * GameObject Constructor for GUI version.
     *
     * @param xStartingLocation Integer representing initial x position of GameObject
     * @param yStartingLocation Integer representing initial y position of GameObject
     */
    public GameObject(int xStartingLocation, int yStartingLocation) {
        setX(xStartingLocation);
        setY(yStartingLocation);
    }

    /**
     * GameObject Constructor for text based version.
     *
     * @param width             Integer representing the width of the GameObject
     * @param xStartingLocation Integer representing initial x position of GameObject
     * @param yStartingLocation Integer representing initial y position of GameObject
     */
    public GameObject(int width, int xStartingLocation, int yStartingLocation) {
        setX(xStartingLocation);
        setY(yStartingLocation);
        this.width = width;
    }

    // Getters

    /**
     * Returns the x position of the GameObject
     *
     * @return Integer representing x position of GameObject
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x position of the GameObject
     *
     * @param newLocation new x location of GameObject
     */
    public void setX(int newLocation) {
        x = newLocation;
    }

    /**
     * Returns the y position of the GameObject
     *
     * @return Integer representing y position of GameObject
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y position of the GameObject
     *
     * @param newLocation new y location of GameObject
     */
    public void setY(int newLocation) {
        y = newLocation;
    }

    /**
     * Returns the width of the GameObject
     *
     * @return Integer representing width of GameObject
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns char used to represent GameObject in text based version
     *
     * @return char used to represent GameObject
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Sets the char used to represent GameObject in text based Version
     *
     * @param newSymbol char used to represent GameObject
     */
    public void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }

    //Setters

    /**
     * Returns the Image used to draw the GameObject
     *
     * @return Image representing the GameObject
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the Image used to represent GameObject in GUI based Version
     *
     * @param path String containing path to the image used to represent GameObject
     */
    public void setImage(String path) {
        image = MediaLoader.loadImage(path);
    }

    /**
     * Returns a Rectangle representing the boundaries of the GameObject (for
     * collision detection)
     *
     * @return Rectangle representing the spatial boundaries of the GameObject
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Sets game objects width and height to the image size.
     */
    public void getImageDimensions() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

}
