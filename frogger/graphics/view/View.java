package frogger.graphics.view;

import frogger.model.Frog;
import frogger.model.GameObstacle;
import frogger.util.CountdownTimer;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Handles Display related actions for the text version of the game.
 * View is a Parent class to ViewText and ViewGUI
 * Inherits from JPanel.
 */
public class View extends JPanel {
    protected int score;
    protected int highScore;
    protected Frog frog;
    protected final int screenSize;
    protected ArrayList<GameObstacle> obstacles;
    protected CountdownTimer countdownTimer;

    /**
     * Constructor for View
     * frog, obstacles, and countdownTimer are all privacy leaked.
     * frog is privacy leaked due to its values being constantly updated and View needing direct access to those values.
     * obstacles is also privacy leaked due to needing access to values being updated constantly.
     * The countdown timer is privacy leaked due to the need for the time to be the same across all classes.
     *
     * @param frog       The Frog object which the player controls.
     * @param screenSize The Display's screen size.
     * @param obstacles  An ArrayList containing the Game Obstacles.
     */
    public View(Frog frog, int screenSize, ArrayList<GameObstacle> obstacles, CountdownTimer countdownTimer) {
        this.frog = frog;
        this.screenSize = screenSize;
        this.obstacles = obstacles;
        this.countdownTimer = countdownTimer;
    }

    //Setters

    public void setScore(int score) {
        this.score = score;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
