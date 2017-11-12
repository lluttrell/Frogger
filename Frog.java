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
     * GUI constructor for Frog Object
     *
     * @param startX Initial X location for Frog
     * @param startY Initial Y location for Frog
     */
    public Frog(int startX, int startY) {
        super(startX, startY);
        this.startX = startX;
        this.startY = startY;
        setImage("res/frog.png");
        getImageDimensions();
    }

    /**
     * Text Constructor for frog Object
     *
     * @param width  width of frog (number of characters wide)
     * @param startX Initial X location for Frog
     * @param startY Initial Y location for Frog
     */
    public Frog(int width, int startX, int startY) {
        super(width, startX, startY);
        this.startX = startX;
        this.startY = startY;
        setSymbol('F');
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
