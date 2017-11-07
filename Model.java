import java.awt.*;
import java.util.ArrayList;

public class Model {
    private final int RIVER_STARTING_Y = 200;
    private Frog frog;
    private Board board;
    private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();

    public Model(Frog frog, ArrayList<GameObstacle> obstacles, Board board) {
        this.frog = frog;
        this.obstacles = obstacles;
        this.board = board;
    }

    /**
     * Move frog when the player input direction,
     * and check frog's y-coordinate to know whether game continues.
     */
    public void updateFrog() {
        frog.move();

        if (frog.getY() == 1) {
            board.setRunningFalse();
            board.setWonFalse();
        }

        if (frog.getLives() == 0) {
            board.setRunningFalse();
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
        Rectangle player = frog.getBounds();
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
