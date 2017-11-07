/**
 * Handles the frog.
 * Inherits from GameObject.
 * adapted from http://zetcode.com/tutorials/javagamestutorial/collision/
 */

public class Frog extends GameObject {

    private int lives = 3;
    private ControllerGUI controllerGUI;
    private int startX, startY;

    //GUI constructor
    public Frog(ControllerGUI controllerGUI, int startX, int startY) {
        super(startX, startY);
        this.controllerGUI = controllerGUI;
        this.startX = startX;
        this.startY = startY;
        setImage("images/frog.png");
        setSymbol('F');
        getImageDimensions();
    }

    public void move() {
        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }

        if (x > controllerGUI.getScreenSize() - 35) { //Somehow add screen collisions for text version.
            x = controllerGUI.getScreenSize() - 35;
        }

        if (y > controllerGUI.getScreenSize() - 60) {
            y = controllerGUI.getScreenSize() - 60;
        }
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
