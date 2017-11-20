import java.awt.*;
import java.util.ArrayList;

/**
 * Acts as the model for View version.
 * Handles moving all entities in the game and checking win or loss state.
 */
public class ModelGUI extends Model {
	
	/**
     * Privacy leak caused by assigning objects passed in as parameters directly 
     * to class’s instance variables. These privacy leaks are not prevented, 
     * because the model needs to be aware of changes made by other classes to 
     * instance variable like frog and game obstacles.
     */
    public ModelGUI(Frog frog, ArrayList<GameObstacle> obstacles, Controller controller) {
        super(frog, obstacles, controller);
    }

    /**
     * Checks if the player collides with game obstacles.
     * Uses Rectangles set to the image sizes of the entities.
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
