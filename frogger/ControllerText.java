package frogger;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ControllerText extends Controller implements ActionListener {
    // Constants
    private static final int SCREEN_SIZE = 14;
    private static final int FROG_X_START = 6;
    private static final int FROG_Y_START = SCREEN_SIZE - 1;
    private final static int DELAY = 600;

    private ModelText modelText;
    private ViewText viewText;

    /**
     * Default constructor.
     */
    public ControllerText() {
        super(SCREEN_SIZE, FROG_X_START, FROG_Y_START, DELAY);
        initBoard();
    }

    /**
     * Initializes all objects.
     */
    private void initBoard() {
        modelText = new ModelText(frog, obstacles, this);
        viewText = new ViewText(frog, SCREEN_SIZE, obstacles, modelText.getRiverStartingY());
        readWorld("res/worlds/world1Text.txt");
        viewText.addKeyListener(keyManager);
        viewText.setFocusable(true);
        viewText.setDoubleBuffered(true);
    }

    public void tick() {
        super.tick();
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

    protected void getInput() {
        if (keyManager.up && frog.getY() > 0) {
            frog.setY(frog.getY() - 1);
        } else if (keyManager.down && frog.getY() < SCREEN_SIZE - 1) {
            frog.setY(frog.getY() + 1);
        } else if (keyManager.left && frog.getX() > 0) {
            frog.setX(frog.getX() - 1);
        } else if (keyManager.right && frog.getX() < SCREEN_SIZE - 1) {
            frog.setX(frog.getX() + 1);
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
                    obstacles.add(new Log(width, x, y, direction, SCREEN_SIZE));
                }
                int numCar = sc.nextInt();
                for (int i = 0; i < numCar; i++) {
                    int width = sc.nextInt();
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    obstacles.add(new Car(width, x, y, direction, SCREEN_SIZE));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ViewText getViewText() {
        return viewText;
    }
}
