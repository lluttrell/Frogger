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
        //Background music
        MediaLoader.playSound();
    }

    /**
     * Initializes all objects.
     */
    private void initBoard() {
        viewGUI = new ViewGUI(frog, SCREEN_SIZE, obstacles);
        modelGUI = new ModelGUI(frog, obstacles, this);

        viewGUI.addKeyListener(keyManager);
        viewGUI.setFocusable(true);
        viewGUI.setDoubleBuffered(true);
        running = true;

    }

    /**
     * Change objects' locations when action happens,
     * and check whether frog collides with obstacles
     * then repaint new objects
     */
    @Override
    public void tick() {
        viewGUI.repaint();
    }

    public void checkGameState() {
        if (running) {
            viewGUI.doDrawing(g);
        } else if (won) {
            showEndScreen(g, "You Win!");
        } else {
            showEndScreen(g, "You Lose :(");
        }
    }
}
