package frogger;

import java.util.ArrayList;

/**
 * Parent class to ModelGUI and ModelText.
 * Handles game logic and updating positions.
 */
public class Model {
    private int score = 3000;
    protected Frog frog;
    private boolean running;
    private boolean won = false;
    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();

    /**
     * Constructor for Model
     *
     * @param frog      The Frog object which the player controls.
     * @param obstacles An ArrayList containing the Game Obstacles.
     */
    public Model(Frog frog, ArrayList<GameObstacle> obstacles) {
        this.frog = frog;
        this.obstacles = obstacles;
        running = true;
    }

    /**
     * Move frog when the player input direction,
     * and check frog's y-coordinate to know whether game continues.
     */
    public void updateFrog() {

        if (frog.getY() == 0) { //Reaches end
            running = false;

            won = true;
        }

        if (frog.getLives() == 0) { //Runs out of lives
            running = false;
        }
    }

    /**
     * Move cars and logs.
     */
    public void updateObstacles() {
        for (GameObstacle o : obstacles) {
            o.move();
        }
    }

    public boolean getRunning() {
        return running;
    }

    public boolean getWon() {
        return won;
    }
}
