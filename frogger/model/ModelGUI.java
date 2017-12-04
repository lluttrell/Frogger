package frogger.model;

import frogger.util.CountdownTimer;

import java.awt.*;
import java.util.ArrayList;

/**
 * Acts as the model GUI version.
 * Handles moving all entities in the game and checking win or loss state.
 */
public class ModelGUI extends Model {

    public ModelGUI(Frog frog, ArrayList<GameObstacle> obstacles, CountdownTimer countdownTimer) {
        super(frog, obstacles, countdownTimer);
    }

    /**
     * Checks if the player collides with game obstacles.
     * Uses Rectangles set to the image sizes of the entities.
     * Code is duplicated due to how collisions in the GUI version use rectangles based on image size.
     */
    public void checkCollisions() {
        Rectangle player = frog.getBounds();
        int RIVER_STARTING_Y = 200;
        //Checking if frog is on a platform in the river.
        if (frog.getY() < RIVER_STARTING_Y) {
            boolean overLap = false;

            for (GameObstacle o : obstacles) {
                Rectangle obs = o.getBounds();
                if (player.intersects(obs) && !o.isDangerous()) {
                    overLap = true;
                    if (o.getDirection() == 'R') {
                        frog.setX(frog.getX() + 1);
                    } else {
                        frog.setX(frog.getX() - 1);
                    }
                }
            }
            if (!overLap) {
                frog.die();
            }
        }

        //Checking if Frog collides with a dangerous obstacle.
        for (GameObstacle o : obstacles) {
            Rectangle obs = o.getBounds();

            if (player.intersects(obs) && o.isDangerous()) {
                frog.die();
            }
        }
    }
}
