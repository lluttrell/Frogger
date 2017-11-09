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
    private final int DELAY = 600;

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

        frog = new Frog(1, FROG_STARTING_X, FROG_STARTING_Y);
        modelText = new ModelText(frog, obstacles, this);
        viewText = new ViewText(frog, obstacles, SCREEN_SIZE, SCREEN_SIZE, modelText.getRiverStartingY());

        viewText.addKeyListener(keyManager);
        viewText.setFocusable(true);
        viewText.setDoubleBuffered(true);
        running = true;

        readWorld("worlds/world1Text.txt");

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
        move();
        modelText.updateFrog();
        modelText.checkCollisions();

        if (running) {
            viewText.doDrawing();
        } else if (won) {
            System.out.println("\n**YOU WIN**");
            System.exit(0);
        } else {
            System.out.println("\n**GAME OVER**");
            System.exit(0);
        }
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

        if (frog.getX() > SCREEN_SIZE) {
            frog.setX(SCREEN_SIZE);
        }

        if (frog.getY() > SCREEN_SIZE) {
            frog.setY(SCREEN_SIZE);
        }
    }



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
                    obstacles.add(new Log(width, x, y, direction));
                }
                int numCar = sc.nextInt();
                for (int i = 0; i < numCar; i++) {
                    int width = sc.nextInt();
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    obstacles.add(new Car(width, x, y, direction));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Getters

    public ViewText getViewText() {
        return viewText;
    }

    public int getScreenSize() {
        return SCREEN_SIZE;
    }

    //Setters

    public void setWonFalse() {
        won = true;
    }

    public void setRunningFalse() {
        running = false;
    }
}
