import javax.swing.*;
import java.util.ArrayList;

public class View extends JPanel {
    protected Frog frog;
    protected final int screenSize;
    protected ArrayList<GameObstacle> obstacles = new ArrayList<>();

    public View(Frog frog, int screenSize, ArrayList<GameObstacle> obstacles) {
        this.frog = frog;
        this.screenSize = screenSize;
        this.obstacles = obstacles;
    }
}
