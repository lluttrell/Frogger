package frogger;

import frogger.util.CountdownTimer;
import frogger.util.KeyManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * An abstract class that is a parent class to ControllerGUI and ControllerText.
 * Implements the ActionListener interface.
 * Handles user input and acts as an in-between for Model and View.
 */
public abstract class Controller implements ActionListener {

    protected boolean running;
    protected boolean won = false;
    private final int screenSize;

    protected Frog frog;
    protected KeyManager keyManager;
    private Model model;
    protected CountdownTimer countdownTimer;

    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();

    /**
     * Constructor for Controller.
     *
     * @param screenSize The game's screen size.
     * @param frogXStart The Frog object's x co-ordinate.
     * @param frogYStart The Frog object's x co-ordinate.
     * @param delay      Delay for the game timer.
     */
    public Controller(int screenSize, int frogXStart, int frogYStart, int delay) {
        frog = new Frog(frogXStart, frogYStart);
        this.screenSize = screenSize;
        initBoard(delay);
    }

    /**
     * Initializes the Controllers objects.
     *
     * @param delay Delay for game timer.
     */
    private void initBoard(int delay) {
        keyManager = new KeyManager();
        countdownTimer = new CountdownTimer();
        model = new Model(frog, obstacles, countdownTimer);
        Timer timer = new Timer(delay, this);
        countdownTimer.start();
        timer.start();
    }

    /**
     * Is called every time timer updates.
     */
    public void actionPerformed(ActionEvent e) {
        tick();
    }

    /**
     * Handles updating the game.
     */
    public void tick() {
        model.updateObstacles();
        keyManager.tick();
        getInput();
        model.updateFrog();
        running = model.getRunning();
        won = model.getWon();
    }

    protected abstract void getInput();

    public int getScreenSize() {
        return screenSize;
    }
}