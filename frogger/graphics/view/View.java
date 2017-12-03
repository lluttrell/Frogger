package frogger.graphics.view;

import frogger.model.Frog;
import frogger.model.GameObstacle;
import frogger.util.CountdownTimer;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Parent class to ViewText and ViewGUI
 * Inherits from JPanel.
 */
public class View extends JPanel {
    protected int score;
    protected Frog frog;
    protected final int screenSize;
    protected ArrayList<GameObstacle> obstacles;
    protected CountdownTimer countdownTimer;

    /**
     * Constructor for View
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

    public void setScore(int score) {
        this.score = score;
    }
}
