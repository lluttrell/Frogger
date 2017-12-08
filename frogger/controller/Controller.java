package frogger.controller;

import frogger.model.Frog;
import frogger.model.GameObstacle;
import frogger.model.Model;
import frogger.util.CountdownTimer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * An abstract class that is a parent class to ControllerGUI and ControllerText.
 * Implements the ActionListener interface.
 * Handles user input and acts as an in-between for Model and View.
 */
public abstract class Controller implements ActionListener {

    protected boolean running;
    protected boolean won = false;
    protected int score;
    protected int highScore;

    protected Frog frog;
    public KeyManager keyManager;
    private Model model;
    protected CountdownTimer countdownTimer;

    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();

    /**
     * Constructor for Controller.
     *
     * @param frogXStart The Frog object's x co-ordinate.
     * @param frogYStart The Frog object's x co-ordinate.
     * @param delay      Delay for the game timer.
     */
    public Controller(int frogXStart, int frogYStart, int delay) {
        frog = new Frog(frogXStart, frogYStart);
        initBoard(delay);
    }

    /**
     * Initializes the Controller's objects.
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
        readHighScore();
    }

    /**
     * Creates world file object and calls writeDefaultWorld if the file doesn't already exist.
     *
     * @param path Path to the world file.
     * @throws IOException
     */
    protected void initWorld(String path) throws IOException {
        File worldFile = new File(path);
        if (!worldFile.exists()) {
            writeDefaultWorld(worldFile);
        }

        readWorld(worldFile);
    }

    /**
     * Obtains highscore from highscore file, if the file does not exist a default file with zero high score is created.
     */
    private void readHighScore() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("res/highscore.txt"));
            String line = reader.readLine();
            while (line != null) {
                try {
                    highScore = Integer.parseInt(line.trim());
                } catch (NumberFormatException e1) {
                    //ignore invalid scores
                    System.out.println("ignoring invalid score: " + line);
                }
                line = reader.readLine();
            }
            reader.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("High score file not found, generating a file with zero high score.");
            writeScore(0);
        } catch (IOException ex) {
            System.out.println("Error reading scores from file");
        }
    }

    /**
     * Compares the current score and high score, if the current score is higher than the high score it becomes the new high score.
     */
    protected void compareScore() {
        if (score > highScore) {
            highScore = score;
        }
        writeScore(highScore);
    }

    /**
     * Writes the high score to a text file.
     *
     * @param score The score to write to a text file.
     */
    private void writeScore(int score) {
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("res/highscore.txt")));
            writer.println(score);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void reset() {
        model.setRunning(true);
        model.setWon(false);
        won = false;
        frog.resetFrog();
        frog.setLives(3);
        countdownTimer.setCountDown(30);
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
        model.updateScore();
        this.score = model.getScore();
        running = model.getRunning();
        won = model.getWon();
    }

    protected abstract void getInput();

    protected abstract void writeDefaultWorld(File worldFile) throws IOException;

    protected abstract void readWorld(File worldFile) throws IOException;
}