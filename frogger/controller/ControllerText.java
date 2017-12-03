package frogger.controller;

import frogger.graphics.view.ViewText;
import frogger.model.GameObstacle;
import frogger.model.ModelText;

import java.awt.event.ActionListener;
import java.io.*;
import java.util.InputMismatchException;
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
    public ControllerText() throws IOException {
        super(FROG_X_START, FROG_Y_START, DELAY);
        initBoard();
    }

    /**
     * Initializes all objects.
     */
    private void initBoard() throws IOException {
        modelText = new ModelText(frog, obstacles, countdownTimer);
        viewText = new ViewText(frog, SCREEN_SIZE, obstacles, modelText.getRiverStartingY(), countdownTimer);
        initWorld();
        viewText.addKeyListener(keyManager);
        viewText.setFocusable(true);
        viewText.setDoubleBuffered(true);
    }

    private void initWorld() throws IOException {
        File worldFile = new File("res/worlds/world1Text.txt");
        if (!worldFile.exists()) {
            writeDefaultWorld(worldFile);
        }

        readWorld(worldFile);
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
            frog.move(0, -1);
        } else if (keyManager.down && frog.getY() < SCREEN_SIZE - 1) {
            frog.move(0, 1);
        } else if (keyManager.left && frog.getX() > 0) {
            frog.move(-1, 0);
        } else if (keyManager.right && frog.getX() < SCREEN_SIZE - 1) {
            frog.move(1, 0);
        }
    }

    private void writeDefaultWorld(File worldFile) throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(worldFile)));
        int numLog = 3;
        int width = 3;
        int x = 0;
        writer.println(numLog);
        writer.print(width + " ");
        writer.print(x + " ");
        writer.println("3 " + "R");
        writer.print(width + " ");
        writer.print(x + " ");
        writer.println("2 " + "L");
        writer.print(width + " ");
        writer.print(x + " ");
        writer.println("1 " + "R");
        writer.println();

        int numCar = 3;

        writer.println(numCar);
        writer.print(width + " ");
        writer.print(x + " ");
        writer.println("10 " + "L");
        writer.print(width + " ");
        writer.print(x + " ");
        writer.println("8 " + "R");
        writer.print(width + " ");
        writer.print(x + " ");
        writer.println("6 " + "L");

        writer.close();
    }

    /**
     * Constructs obstacles based on text file.
     * Duplicated code due to width being retrieved in the middle of the loop to be used for text constructor.
     *
     * @param worldFile The File containing world info.
     */
    private void readWorld(File worldFile) throws IOException {
        try {
            Scanner sc = new Scanner(worldFile);

            while (sc.hasNext()) {
                int numPlatforms = sc.nextInt();
                //Initialize platforms.
                for (int i = 0; i < numPlatforms; i++) {
                    int width = sc.nextInt();
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    GameObstacle temp = new GameObstacle(width, x, y, direction, SCREEN_SIZE);

                    temp.setSymbol('L');

                    obstacles.add(temp);
                }
                int numCar = sc.nextInt();
                //Initialize collidables.
                for (int i = 0; i < numCar; i++) {
                    int width = sc.nextInt();
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    GameObstacle temp = new GameObstacle(width, x, y, direction, SCREEN_SIZE);

                    temp.setSymbol('X');
                    temp.setDangerous(true);

                    obstacles.add(temp);
                }
            }
        } catch (IOException e) {
            System.out.println("Can't access world file, generating default...");
            writeDefaultWorld(new File("res/worlds/world1Text.txt"));
        } catch (InputMismatchException e) {
            System.out.println("World file has invalid values, generating default...");
            writeDefaultWorld(new File("res/worlds/world1Text.txt"));
        }
    }

    public ViewText getViewText() {
        return viewText;
    }
}
