import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

    protected boolean running;
    protected boolean won = false;
    private final int screenSize;

    private Timer timer;
    protected Frog frog;
    protected KeyManager keyManager;
    private Model model;

    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();

    public Controller(int screenSize, int frogXStart, int frogYStart, int delay) {
        frog = new Frog(frogXStart, frogYStart);
        this.screenSize = screenSize;
        initBoard(frogXStart, frogYStart, delay);
    }

    private void initBoard(int frogXStart, int frogYStart, int delay) {
        keyManager = new KeyManager();
        model = new Model(frog, obstacles, this);
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    /**
     * Change objects' locations when action happens,
     * and check whether frog collides with obstacles
     * then repaint new objects
     */
    public void actionPerformed(ActionEvent e) {
        tick();
    }

    public void tick() {
        model.updateObstacles();
        keyManager.tick();
        getInput();
        checkBounds();
        model.updateFrog();
    }

    /**
     * Handles user input.
     */
    private void getInput() {
        if (keyManager.up) {
            frog.setY(frog.getY() - 1);
        } else if (keyManager.down) {
            frog.setY(frog.getY() + 1);
        } else if (keyManager.left) {
            frog.setX(frog.getX() - 1);
        } else if (keyManager.right) {
            frog.setX(frog.getX() + 1);
        }
    }

    /**
     * Constrains frog to screen.
     */
    private void checkBounds() {
        if (frog.getX() < 1) {
            frog.setX(1);
        }

        if (frog.getY() == 0) {
            frog.setY(0);
        }

        if (frog.getX() >= screenSize) {
            frog.setX(screenSize);
        }

        if (frog.getY() == screenSize) {
            frog.setY(screenSize);
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public int getScreenSize() {
        return screenSize;
    }
}
