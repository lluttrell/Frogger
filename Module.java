import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class Module extends JPanel {
    private final int RIVER_STARTING_Y = 200;
    private Frog frog;
    private boolean running=true;
    private boolean won;
    private KeyManager keyManager;
    private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();

    /**Change objects' locations when action happens,
     * and check whether frog collides with obstacles
     * then repaint new objects
     */
    public void actionPerformed(ActionEvent e) {
        updateObstacles();
        updateFrog();
        checkCollisions();
        repaint();
    }

    /**
     * Getter for keyManager
     * @return KeyManager the module's KeyManager
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }

    /**
     * Move frog when the player input direction,
     * and check frog's y-coordinate to know whether game continues.
     */
    public void updateFrog() {
        keyManager.tick();
        frog.getInput();
        frog.move();


        if (frog.getY() == 1) {
            running = false;
            won = true;
        }

        if (frog.getLives() == 0) {
            running = false;
        }
    }

    /**
     * Move cars and logs.
     */
    public void updateObstacles() {
        for(GameObstacle o : obstacles) {
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

            for (GameObstacle o: obstacles) {
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
