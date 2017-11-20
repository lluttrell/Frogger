import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller implements ActionListener {

    protected boolean running;
    protected boolean won = false;
    private int screenSize;

    private Timer timer;
    protected Frog frog;
    protected KeyManager keyManager;
    private Model model;

    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();

    public Controller(int screenSize, int frogXStart, int frogYStart, int delay) {
        this.screenSize = screenSize;
        initBoard(frogXStart, frogYStart, delay);
    }

    private void initBoard(int frogXStart, int frogYStart, int delay) {
        keyManager = new KeyManager();
        frog = new Frog(1, frogXStart, frogYStart);
        running = true;
        readWorld("worlds/world1Text.txt");
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
    public void getInput() {
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
    public void checkBounds() {
        if (frog.getX() < 1) {
            frog.setX(1);
        }

        if (frog.getY() < 1) {
            frog.setY(1);
        }

        if (frog.getX() > screenSize) {
            frog.setX(screenSize);
        }

        if (frog.getY() > screenSize) {
            frog.setY(screenSize);
        }
    }

    /**
     * Constructs obstacles based on text file.
     *
     * @param path path to the text file
     */
    private void readWorld(String path) {
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                int numLog = sc.nextInt();
                for (int i = 0; i < numLog; i++) {
                    int width = sc.nextInt();
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    obstacles.add(new Log(width, x, y, direction, screenSize));
                }
                int numCar = sc.nextInt();
                for (int i = 0; i < numCar; i++) {
                    int width = sc.nextInt();
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    obstacles.add(new Car(width, x, y, direction, screenSize));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}
