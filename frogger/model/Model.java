package frogger.model;

import frogger.util.CountdownTimer;

import java.util.ArrayList;

/**
 * Parent class to ModelGUI and ModelText.
 * Handles game logic and updating positions.
 */
public class Model {
    private int score;
    protected Frog frog;
    private boolean running;
    private boolean won = false;
    protected ArrayList<GameObstacle> obstacles;
    private CountdownTimer countdownTimer;

    /**
     * Constructor for Model
     * frog, obstacles, and countdownTimer are all privacy leaked.
     * frog is privacy leaked due to its values being constantly updated and View needing direct access to those values.
     * obstacles is also privacy leaked due to needing access to values being updated constantly.
     *
     * @param frog      The Frog object which the player controls.
     * @param obstacles An ArrayList containing the Game Obstacles.
     */
    public Model(Frog frog, ArrayList<GameObstacle> obstacles, CountdownTimer countdownTimer) {
        this.frog = frog;
        this.obstacles = obstacles;
        this.countdownTimer = countdownTimer;
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

        if (countdownTimer.getSecondsRemaining() == 0) {//time runs out
            running = false;
        }
    }

    /**
     * Updates game score based on time left and lives left.
     */
    public void updateScore() {
        score = countdownTimer.getSecondsRemaining() * 100 + (frog.getLives() * 100);
    }

    /**
     * Move obstacles.
     */
    public void updateObstacles() {
        for (GameObstacle o : obstacles) {
            o.move();
        }
    }

    //Getters

    public boolean getRunning() {
        return running;
    }

    public boolean getWon() {
        return won;
    }

    public int getScore() {
        return score;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}
