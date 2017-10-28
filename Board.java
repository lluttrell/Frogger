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

  public Board() {

      initBoard();
  }

  private void initBoard() {

      keyManager = new KeyManager();

      addKeyListener(keyManager);
      setFocusable(true);
      background = ImageLoader.loadImage("/background.png");

      frog = new Frog(this, "/frog.png", 240, 420);

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
      g2d.drawImage(frog.getImage(), frog.getX(), frog.getY(), this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

      keyManager.tick();
      frog.getInput();
      frog.move();
      repaint();
  }

  public KeyManager getKeyManager() {
    return keyManager;
  }
}
