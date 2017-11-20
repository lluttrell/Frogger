import java.util.ArrayList;

public class Model {
    protected Frog frog;
    private Controller controller;
    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();
    
    /**
     * Privacy leak caused by assigning objects passed in as parameters directly 
     * to class’s instance variables. These privacy leaks are not prevented, 
     * because the model needs to be aware of changes made by other classes to 
     * instance variable like frog and game obstacles.
     */
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
            controller.setWon(true);
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
}
