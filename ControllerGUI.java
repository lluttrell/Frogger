import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * ControllerGUI handles the main game logic and game loop.
 * Acts as Controller for View version of Frogger based on MVC model.
 * Adapted from http://zetcode.com/tutorials/javagamestutorial/pacman/
 * background image obtained from https://i.imgur.com/iFW8JM4.png
 *
 * @author Iden Craven
 * @author Richard Williams
 */
public class ControllerGUI extends Controller {

    private static final int FROG_X_START = 225;
    private static final int FROG_Y_START = 420;
    private static final int DELAY = 10;
    private static final int SCREEN_SIZE = 480;

    private ViewGUI viewGUI;
    private ModelGUI modelGUI;

    /**
     * Default constructor.
     */
    public ControllerGUI() {
        super(SCREEN_SIZE, FROG_X_START, FROG_Y_START, DELAY);
        initBoard();
        //Background music
        MediaLoader.playSound();
    }

    /**
     * Initializes all objects.
     */
    private void initBoard() {
        frog.getImageDimensions();
        viewGUI = new ViewGUI(frog, SCREEN_SIZE, obstacles);
        modelGUI = new ModelGUI(frog, obstacles, this);
        readWorld("worlds/world1.txt");
        viewGUI.addKeyListener(keyManager);
        viewGUI.setFocusable(true);
        viewGUI.setDoubleBuffered(true);
    }

    /**
     * Change objects' locations when action happens,
     * and check whether frog collides with obstacles
     * then repaint new objects
     */
    @Override
    public void tick() {
        super.tick();
        viewGUI.repaint();
        modelGUI.checkCollisions();
        //checkGameState();
    }

   /* public void checkGameState() {
        if (running) {
            viewGUI.doDrawing();
        } else if (won) {
            viewGUI.showEndScreen("You Win!");
        } else {
            viewGUI.showEndScreen("You Lose :(");
        }
    }*/

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
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    obstacles.add(new Log(x, y, direction, SCREEN_SIZE));
                }
                int numCar = sc.nextInt();
                for (int i = 0; i < numCar; i++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    obstacles.add(new Car(x, y, direction, SCREEN_SIZE));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ViewGUI getViewGUI() {
        return viewGUI;
    }
}
