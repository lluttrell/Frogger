import java.util.ArrayList;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

  private Timer timer;
  private Frog frog;
  private KeyManager keyManager;
  private final int DELAY = 10;
  private Image background;
  private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();

  public Board() {

      initBoard();
  }

  private void initBoard() {

      keyManager = new KeyManager();

      addKeyListener(keyManager);
      setFocusable(true);
      setDoubleBuffered(true);

      background = ImageLoader.loadImage("/background.png");

      frog = new Frog(240, 420, this);

      GameObstacle log = new GameObstacle(0, 180);
      log.setImage("/ship1.png");
      obstacles.add(log);

      timer = new Timer(DELAY, this);
      timer.start();
  }


  @Override
  public void paintComponent(Graphics g) {

      super.paintComponent(g);

      g.drawImage(background, 0, 0, null);

      doDrawing(g);

      Toolkit.getDefaultToolkit().sync();
  }

  private void doDrawing(Graphics g) {
      Graphics2D g2d = (Graphics2D) g;
      for(GameObstacle o : obstacles) {
        g2d.drawImage(o.getImage(), o.getX(), o.getY(), this);
      }
      g2d.drawImage(frog.getImage(), frog.getX(), frog.getY(), this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
      updateObstacles();
      updateFrog();
      repaint();
  }

  public void updateFrog() {
    keyManager.tick();
    frog.getInput();
    frog.move();
  }

  public void updateObstacles() {
    for(GameObstacle o : obstacles) {
      o.moveRight();
    }
  }

  public KeyManager getKeyManager() {
    return keyManager;
  }
}
