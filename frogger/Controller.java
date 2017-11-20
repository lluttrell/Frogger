package frogger;

import frogger.util.KeyManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class Controller implements ActionListener {

    protected boolean running;
    protected boolean won = false;
    private final int screenSize;

    private Timer timer;
    protected Frog frog;
    protected KeyManager keyManager;
    private Model model;

    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();

    public Controller(int screenSize, int frogXStart, int frogYStart, int delay) {
        frog = new Frog(frogXStart, frogYStart);
        this.screenSize = screenSize;
        initBoard(frogXStart, frogYStart, delay);
    }

    private void initBoard(int frogXStart, int frogYStart, int delay) {
        keyManager = new KeyManager();
        model = new Model(frog, obstacles, this);
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    /**
     * Change objects' locations when action happens,
     * and check whether frog collides with obstacles
     * then repaint new objects
     */
    public void actionPerformed(ActionEvent e) {
        tick();
    }

    public void tick() {
        model.updateObstacles();
        keyManager.tick();
        getInput();
        model.updateFrog();
    }

    protected abstract void getInput();

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public int getScreenSize() {
        return screenSize;
    }
}
