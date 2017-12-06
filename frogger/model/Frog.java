package frogger.model;

import frogger.util.MediaLoader;

/**
 * Handles the frog.
 * Inherits from GameObject.
 * adapted from http://zetcode.com/tutorials/javagamestutorial/collision/
 */

public class Frog extends GameObject {

    private final int startX;
    private final int startY;
    private int lives = 3;

    /**
     * constructor for Frog object which player controls.
     *
     * @param startX Initial X location for frogger.model.Frog
     * @param startY Initial Y location for frogger.model.Frog
     */
    public Frog(int startX, int startY) {
        super(startX, startY);
        width = 1;
        this.startX = startX;
        this.startY = startY;
        setSymbol('F');
        setImage("/res/images/frog_up.png");
    }

    /**
     * Moves the frog based on delta values.
     *
     * @param dx Change in x axis.
     * @param dy Change in y axis.
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /**
     * Returns the number of lives the frog has
     *
     * @return Integer representing the number of lives
     */
    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Decreases the frog's lives by one and resets it's position
     */
    public void die() {
        this.lives--;
        MediaLoader.playSound("res/death_sound.wav");
        resetFrog();
    }

    public void resetFrog() {
        x = startX;
        y = startY;
    }
}
