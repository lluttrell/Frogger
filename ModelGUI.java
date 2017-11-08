import java.awt.*;
import java.util.ArrayList;

public class ModelGUI {
    private Frog frog;
    private ControllerGUI controllerGUI;
    private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();

    public ModelGUI(Frog frog, ArrayList<GameObstacle> obstacles, ControllerGUI controllerGUI) {
        this.frog = frog;
        this.obstacles = obstacles;
        this.controllerGUI = controllerGUI;
    }

    /**
     * Move frog when the player input direction,
     * and check frog's y-coordinate to know whether game continues.
     */
    public void updateFrog() {

        if (frog.getY() == 1) {
            controllerGUI.setRunningFalse();
            controllerGUI.setWonFalse();
        }

        if (frog.getLives() == 0) {
            controllerGUI.setRunningFalse();
        }
    }

    /**
     * Move cars and logs.
     */
    public void updateObstacles() {
        for (GameObstacle o : obstacles) {
            o.move(controllerGUI.getScreenSize());
        }
    }

    /**
     * Checks if the player collides with game obstacles.
     */

    public void checkCollisions() {
        Rectangle player = frog.getBounds();
        int RIVER_STARTING_Y = 200;
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

        for (GameObstacle o : obstacles) {
            Rectangle obs = o.getBounds();

            if (player.intersects(obs) && o.isDangerous()) {
                frog.die();
            }
        }
    }
}
