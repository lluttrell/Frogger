package frogger.model;

import frogger.util.MediaLoader;

/**
 * Handles the frog.
 * Inherits from frogger.model.GameObject.
 * adapted from http://zetcode.com/tutorials/javagamestutorial/collision/
 */

public class Frog extends GameObject {

    private int startX;
    private int startY;
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
        setImage("/images/frog_up.png");
    }

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

    /**
     * Decreases the frog's lives by one and resets it's position
     */
    public void die() {
        this.lives--;
        MediaLoader.playSound("res/death_sound.wav");
        x = startX;
        y = startY;
    }
}
