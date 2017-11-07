import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerText implements ActionListener {
    // Constants
    private final int SCREEN_SIZE = 14;
    private final int FROG_STARTING_X = 6;
    private final int FROG_STARTING_Y = SCREEN_SIZE - 2;
    private final int RIVER_STARTING_Y = SCREEN_SIZE - 7;
    private final int DELAY = 10;

    private boolean running;
    private boolean won = false;

    private Timer timer;
    private Frog frog;
    private KeyManager keyManager;
    private ViewText viewText;
    private ModelText modelText;

    private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();


    /**
     * Default constructor.
     */
    public ControllerText() {
        initBoard();
    }

    /**
     * Initializes all objects.
     */
    private void initBoard() {
        keyManager = new KeyManager();

        //frog = new Frog(this, FROG_STARTING_X, FROG_STARTING_Y);
        //viewText = new ViewText(frog, obstacles, this);
        modelText = new ModelText(frog, obstacles, this);

        viewText.addKeyListener(keyManager);
        viewText.setFocusable(true);
        viewText.setDoubleBuffered(true);
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
        modelText.updateObstacles();
        keyManager.tick();
        getInput();
        modelText.updateFrog();
        modelText.checkCollisions();
        viewText.doDrawing();
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

    //Getters

    public int getScreenSize() {
        return SCREEN_SIZE;
    }

    public boolean getWon() {
        return won;
    }

    public boolean getRunning() {
        return running;
    }

    public ViewText getViewText() {
        return viewText;
    }

    //Setters

    public void setWonFalse() {
        won = true;
    }

    public void setRunningFalse() {
        running = false;
    }
}
