package frogger.graphics.view;

import frogger.controller.KeyManager;
import frogger.graphics.Animation;
import frogger.model.Frog;
import frogger.model.GameObstacle;
import frogger.util.CountdownTimer;
import frogger.util.MediaLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Handles display for GUI version of frogger game.
 * Handles animations for frogger game.
 * Inherits from View.
 */

public class ViewGUI extends View {
    private KeyManager keyManager;
    private boolean running, won;
    private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);
    private final Image background;
    private int direction = 0;

    private BufferedImage[] frogStill;

    private Animation animDown;
    private Animation animUp;
    private Animation animLeft;
    private Animation animRight;

    /**
     * Constructor for ViewGUI
     * frog, obstacles, keyManager and countdownTimer are all privacy leaked.
     * frog is privacy leaked due to its values being constantly updated and View needing direct access to those values.
     * obstacles is also privacy leaked due to needing access to values being updated constantly.
     * keyManager is leaked due to the need for it to be updated in the tick method in Controller.
     * The countdown timer is privacy leaked due to the need for the time to be the same across all classes.
     *
     * @param frog       The Frog object the player controls.
     * @param screenSize The game's screen size.
     * @param obstacles  an ArrayList containing all of the GameObstacles.
     * @param keyManager Used to identify which key is being pressed to update animations.
     */
    public ViewGUI(Frog frog, int screenSize, ArrayList<GameObstacle> obstacles, KeyManager keyManager, CountdownTimer countdownTimer) {
        super(frog, screenSize, obstacles, countdownTimer);
        super.setPreferredSize(new Dimension(screenSize, screenSize));
        super.setLayout(new BorderLayout());
        this.keyManager = keyManager;
        initAnimation();
        background = MediaLoader.loadImage("/res/images/background.png");
    }

    /**
     * Initializes all animation arrays and objects.
     */
    private void initAnimation() {
        //Images for frog facing up.
        BufferedImage[] frogUp = new BufferedImage[2];
        frogUp[0] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_leap_up.png");
        frogUp[1] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_up.png");
        animUp = new Animation(300, frogUp);
        //Images for frog facing down.
        BufferedImage[] frogDown = new BufferedImage[2];
        frogDown[0] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_leap_down.png");
        frogDown[1] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_down.png");
        animDown = new Animation(300, frogDown);
        //Images for frog facing left.
        BufferedImage[] frogLeft = new BufferedImage[2];
        frogLeft[0] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_leap_left.png");
        frogLeft[1] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_left.png");
        animLeft = new Animation(300, frogLeft);
        //Images for frog facing right.
        BufferedImage[] frogRight = new BufferedImage[2];
        frogRight[0] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_leap_right.png");
        frogRight[1] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_right.png");
        animRight = new Animation(300, frogRight);
        //Images for frog being still.
        frogStill = new BufferedImage[4];
        frogStill[0] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_up.png");
        frogStill[1] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_down.png");
        frogStill[2] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_left.png");
        frogStill[3] = (BufferedImage) MediaLoader.loadImage("/res/images/frog_right.png");
    }

    /**
     * Updates animation frames.
     */
    public void tickAnim() {
        animUp.tick();
        animDown.tick();
        animLeft.tick();
        animRight.tick();
    }

    /**
     * Determines which animation to use based on input direction.
     *
     * @return The image that the animation is using currently.
     */
    private BufferedImage getCurrentAnimationFrame() {
        if (keyManager.up) {
            direction = 0;
            return animUp.getCurrentFrame();
        } else if (keyManager.down) {
            direction = 1;
            return animDown.getCurrentFrame();
        } else if (keyManager.left) {
            direction = 2;
            return animLeft.getCurrentFrame();
        } else if (keyManager.right) {
            direction = 3;
            return animRight.getCurrentFrame();
        } else {
            return frogStill[direction];
        }
    }

    /**
     * Handles drawing background and drawing based on game state.
     *
     * @param g graphics object used to draw images.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);

        if (running) {
            doDrawing(g);
        } else if (won) {
            showEndScreen(g, "You Win!");
        } else {
            showEndScreen(g, "You Lose!");
        }
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Draws game entities and lives.
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (GameObstacle o : obstacles) {
            g2d.drawImage(o.getImage(), o.getX(), o.getY(), this);
        }

        g2d.drawImage(getCurrentAnimationFrame(), frog.getX(), frog.getY(), this);
        drawLives(g2d);
        drawTime(g2d);
        drawScore(g2d);
    }

    /**
     * Draws the players current lives in bottom right of screen.
     *
     * @param g2d the 2d graphics object used to draw.
     */
    private void drawLives(Graphics2D g2d) {
        String s;

        g2d.setFont(smallFont);
        g2d.setColor(new Color(0, 0, 0));
        s = "Lives: " + frog.getLives();
        g2d.drawString(s, screenSize - 60, screenSize - 10);
    }

    /**
     * Draws the time remaining in the bottom left of the screen.
     *
     * @param g2d the 2d graphics object used to draw.
     */
    private void drawTime(Graphics2D g2d) {
        String s;

        g2d.setFont(smallFont);
        g2d.setColor(new Color(0, 0, 0));
        s = "Time left: " + countdownTimer.getSecondsRemaining();
        g2d.drawString(s, 10, screenSize - 10);
    }

    /**
     * Draws the player's current score in bottom left of the screen.
     *
     * @param g2d the 2d graphics object used to draw.
     */
    private void drawScore(Graphics2D g2d) {
        String s;
        String hs;

        g2d.setFont(smallFont);
        g2d.setColor(new Color(250, 0, 0));
        s = "Score: " + score;
        hs = "High Score: " + highScore;
        g2d.drawString(s, 10, screenSize - 30);
        g2d.drawString(hs, 10, screenSize - 50);
    }

    /**
     * Draws a box with a message inside it. Used to show win screen or game over.
     *
     * @param s The message inside the box.
     * @param g the graphics object used to draw.
     */
    private void showEndScreen(Graphics g, String s) {
        String restart;
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0, 32, 48));
        g2d.fillRect(50, screenSize / 2 - 30, screenSize - 100, 70);
        g2d.setColor(Color.white);
        g2d.drawRect(50, screenSize / 2 - 30, screenSize - 100, 70);

        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);
        restart = "Press x to restart";

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, (screenSize - metr.stringWidth(s)) / 2, screenSize / 2);
        g2d.drawString(restart, (screenSize - metr.stringWidth(restart)) / 2, (screenSize / 2) + 20);
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setWon(boolean won) {
        this.won = won;
    }
}
