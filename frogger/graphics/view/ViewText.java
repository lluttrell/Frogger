package frogger.graphics.view;

import frogger.model.Frog;
import frogger.model.GameObject;
import frogger.model.GameObstacle;
import frogger.util.CountdownTimer;

import java.util.ArrayList;

/**
 * Handles display for Text version.
 * Inherits from View.
 */

public class ViewText extends View {
    private final int width;
    private final int height;
    private final int riverStartingY;
    private char[][] screenMatrix;

    /**
     * Constructor for ViewText.
     * frog, obstacles, and countdownTimer are all privacy leaked.
     * frog is privacy leaked due to its values being constantly updated and View needing direct access to those values.
     * obstacles is also privacy leaked due to needing access to values being updated constantly.
     * The countdown timer is privacy leaked due to the need for the time to be the same across all classes.
     *
     * @param frog           The Frog object which the player controls.
     * @param screenSize     The Display's screen size.
     * @param obstacles      An ArrayList containing the Game Obstacles.
     * @param riverStartingY The Y co-ordinate that the river begins at.
     */
    public ViewText(Frog frog, int screenSize, ArrayList<GameObstacle> obstacles, int riverStartingY, CountdownTimer countdownTimer) {
        super(frog, screenSize, obstacles, countdownTimer);
        this.width = screenSize;
        this.height = screenSize;
        this.riverStartingY = riverStartingY;
        screenMatrix = new char[this.height][this.width];
        InitScreen();
    }

    /**
     * Fills screenMatrix (play area) with default characters
     */
    private void InitScreen() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                screenMatrix[i][j] = '.';
            }
        }
        addRiver();
    }

    /**
     * Prints the screenMatrix to the console
     */
    private void PrintScreen() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(screenMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * doDrawing handles all of the drawing of objects for text based version.
     */
    public void doDrawing() {
        System.out.println("Lives remaining:" + frog.getLives());
        System.out.println("Time left: " + countdownTimer.getSecondsRemaining());
        score = countdownTimer.getSecondsRemaining() * 100;
        System.out.println("High Score: " + highScore);
        System.out.println("Score: " + score);
        InitScreen();

        //Print obstacles to screen.
        for (GameObject o : obstacles) {
            setObjectOnLocation(o, o.getX(), o.getY());
        }
        setObjectOnLocation(frog, frog.getX(), frog.getY());

        PrintScreen();
    }

    /**
     * Prints the river to the screen with land at the far side of the river.
     */
    private void addRiver() {
        for (int i = 0; i < width; i++) {
            for (int j = riverStartingY - 1; j >= 0; j--) {
                screenMatrix[j][i] = '^';
            }
            screenMatrix[0][i] = '.';
        }
    }

    /**
     * Updates the character at a specified position in the screenMatrix to the
     * character used to represent a GameObject.
     *
     * @param object frogger.model.GameObject moving into the position
     * @param x      x coordinate of frogger.model.GameObject
     * @param y      y coordinate of frogger.model.GameObject
     */
    private void setObjectOnLocation(GameObject object, int x, int y) {
        for (int i = x - object.getWidth() / 2; i <= x + object.getWidth() / 2; i++) {
            screenMatrix[y][i] = object.getSymbol();
        }
    }
}
