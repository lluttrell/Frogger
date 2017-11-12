import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Handles View for GUI version.
 * Inherits from JPanel
 */

public class ViewGUI extends JPanel {

    private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);
    private final Image background;
    private Frog frog;
    private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();
    private ControllerGUI controllerGUI;

    public ViewGUI(Frog frog, ArrayList<GameObstacle> obstacles, ControllerGUI controllerGUI) {
        background = MediaLoader.loadImage("res/background.png");
        this.frog = frog;
        this.obstacles = obstacles;
        this.controllerGUI = controllerGUI;
    }

    /**
     * Handles drawing background and drawing based on game state.
     *
     * @param g Graphics object used to draw images.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);

        if (controllerGUI.getRunning()) {
            doDrawing(g);
        } else if (controllerGUI.getWon()) {
            showEndScreen(g, "You Win!");
        } else {
            showEndScreen(g, "You Lose :(");
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

        drawLives(g2d);

        g2d.drawImage(frog.getImage(), frog.getX(), frog.getY(), this);
    }

    /**
     * Draws a the players current lives in bottom right of screen.
     *
     * @param g2d the 2d graphics object
     */
    private void drawLives(Graphics2D g2d) {

        String s;

        g2d.setFont(smallFont);
        g2d.setColor(new Color(0, 0, 0));
        s = "Lives: " + frog.getLives();
        g2d.drawString(s, controllerGUI.getScreenSize() - 80, controllerGUI.getScreenSize() - 40);
    }

    /**
     * Draws a box with a message inside it. Used to show win screen or game over.
     *
     * @param g the graphics object
     * @param s The message inside the box.
     */
    private void showEndScreen(Graphics g, String s) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0, 32, 48));
        g2d.fillRect(50, controllerGUI.getScreenSize() / 2 - 30, controllerGUI.getScreenSize() - 100, 50);
        g2d.setColor(Color.white);
        g2d.drawRect(50, controllerGUI.getScreenSize() / 2 - 30, controllerGUI.getScreenSize() - 100, 50);

        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, (controllerGUI.getScreenSize() - metr.stringWidth(s)) / 2, controllerGUI.getScreenSize() / 2);
    }
}
