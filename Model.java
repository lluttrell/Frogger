import java.util.ArrayList;

public abstract class Model {
    protected Frog frog;
    private Controller controller;
    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();

    public Model(Frog frog, ArrayList<GameObstacle> obstacles, Controller controller) {
        this.frog = frog;
        this.obstacles = obstacles;
        this.controller = controller;
    }

    /**
     * Move frog when the player input direction,
     * and check frog's y-coordinate to know whether game continues.
     */
    public void updateFrog() {

        if (frog.getY() == 0) { //Reaches end
            controller.setRunning(false);
            controller.setWon(false);
        }

        if (frog.getLives() == 0) { //Runs out of lives
            controller.setRunning(false);
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
    public abstract void checkCollisions();
}
