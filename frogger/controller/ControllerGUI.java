package frogger.controller;

import frogger.graphics.view.ViewGUI;
import frogger.model.GameObstacle;
import frogger.model.ModelGUI;
import frogger.util.MediaLoader;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ControllerGUI handles the user input and acts as an in-between for ViewGUI and ModelGUI
 * Acts as Controller for GUI version of Frogger based on MVC model.
 * background image obtained from https://i.imgur.com/iFW8JM4.png
 */

public class ControllerGUI extends Controller {
    //Constants
    private static final int FROG_X_START = 225;
    private static final int FROG_Y_START = 450;
    private static final int DELAY = 10;
    private static final int SCREEN_SIZE = 480;

    private ViewGUI viewGUI;
    private ModelGUI modelGUI;

    /**
     * Constructor for ControllerGUI.
     */
    public ControllerGUI() throws IOException {
        super(FROG_X_START, FROG_Y_START, DELAY);
        initBoard();
        //Background music
        MediaLoader.playSound("res/SpaceMusic.wav");
    }

    /**
     * Initializes all objects.
     */
    private void initBoard() throws IOException {
        frog.getImageDimensions();
        modelGUI = new ModelGUI(frog, obstacles, countdownTimer);
        viewGUI = new ViewGUI(frog, SCREEN_SIZE, obstacles, keyManager, countdownTimer);
        super.initWorld("res/worlds/world1.txt");
        viewGUI.addKeyListener(keyManager);
        viewGUI.setFocusable(true);
        viewGUI.setDoubleBuffered(true);
    }

    /**
     * Writes a default world's data to a file.
     *
     * @param worldFile The file that is used to write to.
     * @throws IOException
     */
    @Override
    protected void writeDefaultWorld(File worldFile) throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(worldFile)));
        int numShips = 6;

        writer.println(numShips);
        writer.println("0 " + "180 " + "R");
        writer.println("480 " + "130 " + "L");
        writer.println("32 " + "80 " + "R");
        writer.println("480 " + "25 " + "L");
        writer.println("-200 " + "180 " + "R");
        writer.println("800 " + "130 " + "L");
        writer.println();

        int numAsteroids = 3;
        int x = 0;
        writer.println(numAsteroids);
        writer.println(x + " 260 " + "L");
        writer.println(x + " 310 " + "R");
        writer.println(x + " 360 " + "L");

        writer.close();
    }

    /**
     * tick is called every time the gameloop is executed to update everything in the game.
     */
    @Override
    public void tick() {
        viewGUI.tickAnim();
        super.tick();
        modelGUI.checkCollisions();
        viewGUI.setScore(super.score);
        viewGUI.setHighScore(highScore);
        checkGameState();
        viewGUI.repaint();
    }

    @Override
    protected void reset() {
        super.reset();
        viewGUI.setWon(false);
    }

    /**
     * Checks the game's state.
     * States include running and won.
     */
    private void checkGameState() {
        if (running) {
            viewGUI.setRunning(true);
        } else if (won) {
            viewGUI.setRunning(false);
            viewGUI.setWon(true);
            super.compareScore();
        } else {
            viewGUI.setRunning(false);
        }
    }

    /**
     * Handles user input to move the Frog.
     * Code is duplicated due to the different bound checking for GUI and text version.
     */
    @Override
    protected void getInput() {
        if (keyManager.up && frog.getY() > 0) {
            frog.move(0, -1);
        } else if (keyManager.down && frog.getY() < SCREEN_SIZE - 32) {
            frog.move(0, 1);
        } else if (keyManager.left && frog.getX() > 0) {
            frog.move(-1, 0);
        } else if (keyManager.right && frog.getX() < SCREEN_SIZE - 32) {
            frog.move(1, 0);
        } else if (keyManager.restartGame) {
            reset();
        }
    }

    /**
     * Constructs obstacles based on text file.
     * Duplicated code due to width being retrieved in the middle of the loop to be used for text constructor.
     * Also, getImageDimensions is called for the gui version setting the dimensions for the gui obstacles.
     *
     * @param worldFile The File containing world info.
     */
    @Override
    protected void readWorld(File worldFile) throws IOException {
        try {
            Scanner sc = new Scanner(worldFile);

            while (sc.hasNext()) {
                int numShips = sc.nextInt();
                //Initialize ships.
                for (int i = 0; i < numShips; i++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    GameObstacle temp = new GameObstacle(x, y, direction, SCREEN_SIZE);

                    if (direction == 'L') {
                        temp.setImage("/res/images/shipL.png");
                    } else if (direction == 'R') {
                        temp.setImage("/res/images/shipR.png");
                    }
                    temp.getImageDimensions();

                    obstacles.add(temp);
                }
                int numAsteroids = sc.nextInt();
                //Initialize asteroids.
                for (int i = 0; i < numAsteroids; i++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    char direction = sc.next().charAt(0);
                    GameObstacle temp = new GameObstacle(x, y, direction, SCREEN_SIZE);

                    temp.setImage("/res/images/asteroid.png");
                    temp.getImageDimensions();
                    temp.setDangerous(true);

                    obstacles.add(temp);
                }
            }
        } catch (IOException e) {
            System.out.println("Can't access world file, generating default...");
            writeDefaultWorld(new File("res/worlds/world1.txt"));
        } catch (InputMismatchException e) {
            System.out.println("World file has invalid values, generating default...");
            writeDefaultWorld(new File("res/worlds/world1.txt"));
        }
    }

    public ViewGUI getViewGUI() {
        return viewGUI;
    }
}
