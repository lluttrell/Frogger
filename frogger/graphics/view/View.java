package frogger.graphics.view;

import frogger.Frog;
import frogger.GameObstacle;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Parent class to ViewText and ViewGUI
 * Inherits from JPanel.
 */
public class View extends JPanel {
    protected Frog frog;
    protected final int screenSize;
    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();

    /**
     * Constructor for View
     *
     * @param frog       The Frog object which the player controls.
     * @param screenSize The Display's screen size.
     * @param obstacles  An ArrayList containing the Game Obstacles.
     */
    public View(Frog frog, int screenSize, ArrayList<GameObstacle> obstacles) {
        this.frog = frog;
        this.screenSize = screenSize;
        this.obstacles = obstacles;
    }
}
