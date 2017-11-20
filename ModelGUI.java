import java.awt.*;
import java.util.ArrayList;

/**
 * Acts as the model for View version.
 * Handles moving all entities in the game and checking win or loss state.
 */
public class ModelGUI extends Model {

    public ModelGUI(Frog frog, ArrayList<GameObstacle> obstacles, Controller controller) {
        super(frog, obstacles, controller);
    }

    /**
     * Checks if the player collides with game obstacles.
     * Uses Rectangles set to the image sizes of the entities.
     */
    @Override
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
