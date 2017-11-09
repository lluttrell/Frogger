import java.util.ArrayList;

public class ModelText {

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
            move(controllerText.getScreenSize(), o);
        }
    }

    private void move(int boardWidth, GameObstacle obstacle) {
        if (obstacle.getDirection() == 'L') {
            obstacle.setX(obstacle.getX() - obstacle.getSpeed());

            if (obstacle.getX() < boardWidth - (boardWidth - 3)) {
                obstacle.setX(boardWidth - 3);
            }
        } else if (obstacle.getDirection() == 'R') {
            obstacle.setX(obstacle.getX() + obstacle.getSpeed());

            if (obstacle.getX() > boardWidth - 2) {
                obstacle.setX(1);
            }
        }
    }

    /**
     * Checks if the player collides with game obstacles.
     */

    public void checkCollisions() {
        int RIVER_STARTING_Y = 7;
        if (frog.getY() < RIVER_STARTING_Y) {
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
}
