/**
 * Handles the frog.
 * Inherits from GameObject.
 * adapted from http://zetcode.com/tutorials/javagamestutorial/collision/
 */

public class Frog extends GameObject {

    private int lives = 3;
    private final int startX;
    private final int startY;

    //GUI constructor
    public Frog(int startX, int startY) {
        super(startX, startY);
        this.startX = startX;
        this.startY = startY;
        setImage("images/frog.png");
        setSymbol('F');
        getImageDimensions();
    }

    //Text Constructor
    public Frog(int width, int startX, int startY) {
        super(width, startX, startY);
        this.startX = startX;
        this.startY = startY;
        setSymbol('F');
    }

    public int getLives() {
        return this.lives;
    }

    public void die() {
        this.lives--;
        x = startX;
        y = startY;
    }
}
