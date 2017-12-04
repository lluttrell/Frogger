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
    protected KeyManager keyManager;
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
        readHighScore();
    }

    protected void initWorld(String path) throws IOException {
        File worldFile = new File(path);
        if (!worldFile.exists()) {
            writeDefaultWorld(worldFile);
        }

        readWorld(worldFile);
    }

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

    protected void compareScore() {
        if (score > highScore) {
            highScore = score;
        }
        writeScore(highScore);
    }

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