import java.util.ArrayList;

/**
 * Acts as the model for the text-based version of Frogger.
 * Handles moving all entities in the game and checking win or loss state.
 */

public class ModelText extends Model {

    private final int RIVER_STARTING_Y = 4;

    public ModelText(Frog frog, ArrayList<GameObstacle> obstacles, Controller controller) {
        super(frog, obstacles, controller);
    }

    /**
     * Checks if the player collides with game obstacles.
     */
    public void checkCollisions() {
        if (frog.getY() < RIVER_STARTING_Y) { //Frog on river
            boolean overLap = false;

            for (GameObstacle o : obstacles) {
                if (overlapsWith(o) && !o.isDangerous()) {
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

        //Checking for frog colliding with obstacle
        for (GameObstacle o : obstacles) {
            if (overlapsWith(o) && o.isDangerous()) {
                frog.die();
            }
        }
    }

    private boolean overlapsWith(GameObstacle obstacle) {
        for (int i = -1; i < obstacle.getWidth(); i++) {
            if (obstacle.getX() - i == frog.getX() && obstacle.getY() == frog.getY()) {
                return true;
            }
        }
        return false;
    }

    public int getRiverStartingY() {
        return RIVER_STARTING_Y;
    }
}
