import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ControllerGUI handles the main game logic and game loop.
 * Acts as Controller for GUI version of Frogger based on MVC model.
 * Adapted from http://zetcode.com/tutorials/javagamestutorial/pacman/
 * background image obtained from https://i.imgur.com/iFW8JM4.png
 *
 * @author Iden Craven
 * @author Richard Williams
 */
public class ControllerGUI extends JFrame implements ActionListener {

    private static final int FROG_X_START = 240;
    private static final int FROG_Y_START = 420;

    private final int DELAY = 10;
    private final int SCREEN_SIZE = 480;

    private boolean running;
    private boolean won = false;

    private Timer timer;
    private Frog frog;
    private KeyManager keyManager;
    private ViewGUI viewGUI;
    private ModelGUI modelGUI;

    private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();

    /**
     * Default constructor.
     */
    public ControllerGUI() {
        initBoard();
    }

    /**
     * Initializes all objects.
     */
    private void initBoard() {
        keyManager = new KeyManager();

        frog = new Frog(FROG_X_START, FROG_Y_START);
        viewGUI = new ViewGUI(frog, obstacles, this);
        modelGUI = new ModelGUI(frog, obstacles, this);

        viewGUI.addKeyListener(keyManager);
        viewGUI.setFocusable(true);
        viewGUI.setDoubleBuffered(true);
        running = true;

        readWorld("worlds/world1.txt");

        timer = new Timer(DELAY, this);
        timer.start();
    }

    /**
     * Change objects' locations when action happens,
     * and check whether frog collides with obstacles
     * then repaint new objects
     */
    public void actionPerformed(ActionEvent e) {
        modelGUI.updateObstacles();
        keyManager.tick();
        getInput();
        move();
        modelGUI.updateFrog();
        modelGUI.checkCollisions();
        viewGUI.repaint();
    }

    /**
     * Getter for keyManager
     *
     * @return KeyManager the module's KeyManager
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }

    /**
     * Handles user input.
     */
    public void getInput() {
        if (getKeyManager().up) {
            frog.setY(frog.getY() - 1);
        } else if (getKeyManager().down) {
            frog.setY(frog.getY() + 1);
        } else if (getKeyManager().left) {
            frog.setX(frog.getX() - 1);
        } else if (getKeyManager().right) {
            frog.setX(frog.getX() + 1);
        }
    }

    public void move() {
        if (frog.getX() < 1) {
            frog.setX(1);
        }

        if (frog.getY() < 1) {
            frog.setY(1);
        }

        if (frog.getX() > SCREEN_SIZE - 35) {
            frog.setX(SCREEN_SIZE - 35);
        }

        if (frog.getY() > SCREEN_SIZE - 60) {
            frog.setY(SCREEN_SIZE - 60);
        }
    }

    private void readWorld(String path) {
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                int numLog = sc.nextInt();
                for (int i = 0; i < numLog; i++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    obstacles.add(new Log(x, y, direction));
                }
                int numCar = sc.nextInt();
                for (int i = 0; i < numCar; i++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    obstacles.add(new Car(x, y, direction));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter for screen size
     *
     * @return the size of the screen in pixels.
     */
    public int getScreenSize() {
        return SCREEN_SIZE;
    }

    public boolean getWon() {
        return won;
    }

    public boolean getRunning() {
        return running;
    }

    public ViewGUI getViewGUI() {
        return viewGUI;
    }

    public void setWonFalse() {
        won = true;
    }

    public void setRunningFalse() {
        running = false;
    }
}
