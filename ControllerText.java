import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerText extends Controller implements ActionListener {
    // Constants
    private static final int SCREEN_SIZE = 14;
    private static final int FROG_X_START = 6;
    private static final int FROG_Y_START = SCREEN_SIZE - 1;
    private final static int DELAY = 600;

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
        viewText = new ViewText(frog, obstacles, SCREEN_SIZE, SCREEN_SIZE, modelText.getRiverStartingY());

        viewText.addKeyListener(keyManager);
        viewText.setFocusable(true);
        viewText.setDoubleBuffered(true);
        setRunning(true);
    }

    /**
     * Change objects' locations when action happens,
     * and check whether frog collides with obstacles
     * then repaint new objects
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        modelText.updateObstacles();
        keyManager.tick();
        getInput();
        checkBounds();
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
}
