package frogger;

import frogger.util.MediaLoader;

import java.awt.*;

/**
 * Handles Game objects in the game.
 * Parent to frogger.Frog and GameObstacles.
 * Adapted from https://github.com/andreirichkov/console-snake
 *
 * @author Iden Craven
 * @author Richard Williams
 */

public class GameObject {

    //Instance variables.
    protected int x, y;
    protected int width;
    private int height;
    private char symbol;
    private Image image;

    /**
     * frogger.GameObject Constructor
     *
     * @param xStartingLocation Integer representing initial x position of frogger.GameObject
     * @param yStartingLocation Integer representing initial y position of frogger.GameObject
     */
    public GameObject(int xStartingLocation, int yStartingLocation) {
        setX(xStartingLocation);
        setY(yStartingLocation);
    }

    /**
     * frogger.GameObject Constructor for text based version of frogger.GameObject
     *
     * @param width             Integer representing the width of the frogger.GameObject
     * @param xStartingLocation Integer representing initial x position of frogger.GameObject
     * @param yStartingLocation Integer representing initial y position of frogger.GameObject
     */
    public GameObject(int width, int xStartingLocation, int yStartingLocation) {
        setX(xStartingLocation);
        setY(yStartingLocation);
        this.width = width;
    }

    // Getters

    /**
     * Returns the x position of the frogger.GameObject
     *
     * @return Integer representing x position of frogger.GameObject
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x position of the frogger.GameObject
     *
     * @param newLocation new x location of frogger.GameObject
     */
    public void setX(int newLocation) {
        x = newLocation;
    }

    /**
     * Returns the y position of the frogger.GameObject
     *
     * @return Integer representing y position of frogger.GameObject
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y position of the frogger.GameObject
     *
     * @param newLocation new y location of frogger.GameObject
     */
    public void setY(int newLocation) {
        y = newLocation;
    }

    /**
     * Returns the width of the frogger.GameObject
     *
     * @return Integer representing width of frogger.GameObject
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns char used to represent frogger.GameObject in text based version
     *
     * @return char used to represent frogger.GameObject
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Sets the char used to represent frogger.GameObject in text based Version
     *
     * @param newSymbol char used to represent frogger.GameObject
     */
    public void setSymbol(char newSymbol) {
        symbol = newSymbol;
    }

    //Setters

    /**
     * Returns the Image used to draw the frogger.GameObject
     *
     * @return Image representing the frogger.GameObject
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the Image used to represent frogger.GameObject in GUI based Version
     *
     * @param path String containing path to the image used to represent frogger.GameObject
     */
    public void setImage(String path) {
        image = MediaLoader.loadImage(path);
    }

    /**
     * Returns a Rectangle representing the boundaries of the frogger.GameObject (for
     * collision detection)
     *
     * @return Rectangle representing the spatial boundaries of the frogger.GameObject
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
