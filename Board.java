import java.util.ArrayList;
import java.awt.Rectangle;
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

  public static final int frogXStart = 240;
  public static final int frogYStart = 420;

  private final int DELAY = 10;
  private final int BOARD_SIZE = 480;

  private boolean running;

  private Timer timer;

  private Frog frog;
  private KeyManager keyManager;

  private Image background;
  private Image ground;

  private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();

  public Board() {

      initBoard();
  }

  private void initBoard() {

      keyManager = new KeyManager();

      addKeyListener(keyManager);
      setFocusable(true);
      setDoubleBuffered(true);
      running = true;

      background = ImageLoader.loadImage("images/background.png");
      ground = ImageLoader.loadImage("images/metal.png");

      frog = new Frog(this, frogXStart, frogYStart);

      Log log1 = new Log(0, 180, 'R');
      obstacles.add(log1);

      Log log2 = new Log(480, 80, 'L');
      obstacles.add(log2);

      Car car1 = new Car(0, 260, 'L');
      obstacles.add(car1);

      timer = new Timer(DELAY, this);
      timer.start();
  }


  @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(background, 0, 0, null);
      if (running) {
        doDrawing(g);
      }

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
      checkCollisions();
      repaint();
  }

  public void updateFrog() {
    keyManager.tick();
    frog.getInput();
    frog.move();
  }

  public void updateObstacles() {
    for(GameObstacle o : obstacles) {
      o.move();
    }
  }

 public void checkCollisions() {
    Rectangle player = frog.getBounds();

    for (GameObstacle o : obstacles) {
      Rectangle obs = o.getBounds();

      if (player.intersects(obs) && o.isDangerous()) {
        frog.die();
      }
    }
  }

  public KeyManager getKeyManager() {
    return keyManager;
  }
}
