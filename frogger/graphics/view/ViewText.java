package frogger.graphics.view;

import frogger.Frog;
import frogger.GameObject;
import frogger.GameObstacle;

import java.util.ArrayList;

/**
 * Handles frogger.graphics.view.View for Text version.
 * Inherits from JPanel for timer and keyListener.
 */

public class ViewText extends View {
    private final int width;
    private final int height;
    private final int riverStartingY;
    private char[][] screenMatrix;

    /**
     * Constructor for ViewText
     *
     * @param frog           The Frog object which the player controls.
     * @param screenSize     The Display's screen size.
     * @param obstacles      An ArrayList containing the Game Obstacles.
     * @param riverStartingY The Y co-ordinate that the river begins at.
     */
    public ViewText(Frog frog, int screenSize, ArrayList<GameObstacle> obstacles, int riverStartingY) {
        super(frog, screenSize, obstacles);
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
     * character used to represent a frogger.GameObject
     *
     * @param object frogger.GameObject moving into the position
     * @param x      x coordinate of frogger.GameObject
     * @param y      y coordinate of frogger.GameObject
     */
    private void setObjectOnLocation(GameObject object, int x, int y) {
        for (int i = x - object.getWidth() / 2; i <= x + object.getWidth() / 2; i++) {
            screenMatrix[y][i] = object.getSymbol();
        }
    }
}
