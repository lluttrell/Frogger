package frogger;

/**
 * Handles the frog.
 * Inherits from frogger.GameObject.
 * adapted from http://zetcode.com/tutorials/javagamestutorial/collision/
 */

public class Frog extends GameObject {

    private final int startX;
    private final int startY;
    private int lives = 3;

    /**
     * frogger.View constructor for frogger.Frog Object
     *
     * @param startX Initial X location for frogger.Frog
     * @param startY Initial Y location for frogger.Frog
     */
    public Frog(int startX, int startY) {
        super(startX, startY);
        width = 1;
        this.startX = startX;
        this.startY = startY;
        setSymbol('F');
        setImage("/images/frog.png");
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
        x = startX;
        y = startY;
    }
}
