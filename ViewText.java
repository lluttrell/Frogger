import javax.swing.*;
import java.util.ArrayList;

public class ViewText extends JPanel {
    private final int width;
    private final int height;
    private final int riverStartingY;
    private char[][] screenMatrix;

    private Frog frog;
    private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();

    public ViewText(Frog frog, ArrayList<GameObstacle> obstacles, int width, int height, int riverStartingY) {
        this.frog = frog;
        this.obstacles = obstacles;
        this.width = width;
        this.height = height;
        this.riverStartingY = riverStartingY;
        screenMatrix = new char[this.height][this.width];
        InitScreen();
    }

    /**
     * Fills screenMatrix (play area) with default characters
     */
    private void InitScreen() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                screenMatrix[i][j] = '.';
            }
        }
        addRiver();
    }

    /**
     * Prints the screenMatrix to the console
     */
    private void PrintScreen() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(screenMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * doDrawing handles all of the drawing of objects for text based version.
     */
    public void doDrawing() {
        System.out.println("Lives remaining:" + frog.getLives());
        InitScreen();

        //Print obstacles to screen.
        for (GameObject o : obstacles) {
            setObjectOnLocation(o, o.getX(), o.getY());
        }
        setObjectOnLocation(frog, frog.getX(), frog.getY());

        PrintScreen();
    }

    private void addRiver() {
        for (int i = 0; i < width; i++) {
            for (int j = riverStartingY - 1; j >= 0; j--) {
                screenMatrix[j][i] = '^';
            }
        }
    }

    /**
     * Updates the character at a specified position in the screenMatrix to the
     * character used to represent a GameObject
     *
     * @param object GameObject moving into the position
     * @param x      x coordinate of GameObject
     * @param y      y coordinate of GameObject
     */
    private void setObjectOnLocation(GameObject object, int x, int y) {
        for (int i = x - object.getWidth() / 2; i <= x + object.getWidth() / 2; i++) {
            screenMatrix[y][i] = object.getSymbol();
        }

    }
}
