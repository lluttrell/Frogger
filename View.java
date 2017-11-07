import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JPanel {

    private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);
    private Image background;
    private Frog frog;
    private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();
    private Board board;

    public View(Frog frog, ArrayList<GameObstacle> obstacles, Board board) {
        background = ImageLoader.loadImage("images/background.png");
        this.frog = frog;
        this.obstacles = obstacles;
        this.board = board;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);

        if (board.getRunning()) {
            doDrawing(g);
        } else if (board.getWon()) {
            showEndScreen(g, "You Win!");
        } else {
            showEndScreen(g, "You Lose :(");
        }

        Toolkit.getDefaultToolkit().sync();
    }

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
        g2d.drawString(s, board.getScreenSize() - 80, board.getScreenSize() - 40);
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
        g2d.fillRect(50, board.getScreenSize() / 2 - 30, board.getScreenSize() - 100, 50);
        g2d.setColor(Color.white);
        g2d.drawRect(50, board.getScreenSize() / 2 - 30, board.getScreenSize() - 100, 50);

        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);

        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, (board.getScreenSize() - metr.stringWidth(s)) / 2, board.getScreenSize() / 2);
    }
}
