import java.awt.*;
import java.util.ArrayList;

public class ModelText {

    private final int RIVER_STARTING_Y = 200;
    private Frog frog;
    private ControllerText controllerText;
    private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();

    public ModelText(Frog frog, ArrayList<GameObstacle> obstacles, ControllerText controllerText) {
        this.frog = frog;
        this.obstacles = obstacles;
        this.controllerText = controllerText;
    }

    /**
     * Move frog when the player input direction,
     * and check frog's y-coordinate to know whether game continues.
     */
    public void updateFrog() {
        frog.move();

        if (frog.getY() == 1) {
            controllerText.setRunningFalse();
            controllerText.setWonFalse();
        }

        if (frog.getLives() == 0) {
            controllerText.setRunningFalse();
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

    /**
     * Checks if the player collides with game obstacles.
     */

    public void checkCollisions() {
        if (frog.getY() < RIVER_STARTING_Y) {
            boolean overLap = false;

            for (GameObstacle o : obstacles) {
                if (overlapsWith(frog, o) && !o.isDangerous()) {
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

        for (GameObstacle o : obstacles) {
            if (overlapsWith(frog, o) && o.isDangerous()) {
                frog.die();
            }
        }
    }

    public boolean overlapsWith(Frog frog, GameObstacle obstacle) {
        for (int i = -1; i < obstacle.getWidth(); i++) { //How to deal with width between versions?
            if (obstacle.getX() - i == frog.getX() && obstacle.getY() == frog.getY()) {
                return true;
            }
        }
        return false;
    }
}
