import java.util.ArrayList;
import java.awt.Font;
import java.awt.FontMetrics;
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

/**
 * Board handles the main game logic and game loop.
 * Adapted from http://zetcode.com/tutorials/javagamestutorial/pacman/
 * background image obtained from https://i.imgur.com/iFW8JM4.png
 * @author Iden Craven
 * @author Richard Williams
 */
public class Board extends JPanel implements ActionListener {

  private final Font smallFont = new Font("Helvetica", Font.BOLD, 14);
  public static final int frogXStart = 240;
  public static final int frogYStart = 420;

  private final int DELAY = 10;
  private final int SCREEN_SIZE = 480;
  private final int RIVER_STARTING_Y = 200;

  private boolean running;
  private boolean won;

  private Timer timer;

  private Frog frog;
  private KeyManager keyManager;

  private Image background;
  private Image ground;

  private ArrayList<GameObstacle> obstacles = new ArrayList<GameObstacle>();

  /**
   * Default constructor.
   */
  public Board() {

  	initBoard();
  }

  /**
   * Initalizes all objects.
   */
  private void initBoard() {

  	keyManager = new KeyManager();

  	addKeyListener(keyManager);
  	setFocusable(true);
  	setDoubleBuffered(true);
  	running = true;

  	background = ImageLoader.loadImage("images/background.png");

  	frog = new Frog(this, frogXStart, frogYStart);

  	Log log1 = new Log(0, 180, 'R');
  	obstacles.add(log1);

  	Log log2 = new Log(480, 130, 'L');
  	obstacles.add(log2);

  	Log log3 = new Log(32, 80,'R');
  	obstacles.add(log3);

  	Log log4 = new Log(480, 30,'L');
  	obstacles.add(log4);

  	Log log5 = new Log(-200, 180,'R');
  	obstacles.add(log5);

  	Log log6 = new Log(800, 130, 'L');
  	obstacles.add(log6);

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
  	} else if (won) {
  		showEndScreen(g, "You Win!");
  	} else {
  		showEndScreen(g, "You Lose :(");
  	}

  	Toolkit.getDefaultToolkit().sync();
  }

  private void doDrawing(Graphics g) {
  	Graphics2D g2d = (Graphics2D) g;

  	for(GameObstacle o : obstacles) {
  		g2d.drawImage(o.getImage(), o.getX(), o.getY(), this);
  	}

  	drawLives(g2d);

  	g2d.drawImage(frog.getImage(), frog.getX(), frog.getY(), this);
  }

  /**
   * Game loop
   */
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

  	//Player reaches top of the screen
  	if (frog.getY() == 1) {
  		running = false;
  		won = true;
  	}

  	//If player runs out of lives
  	if (frog.getLives() == 0) {
  		running = false;
  	}
  }

  public void updateObstacles() {
  	for(GameObstacle o : obstacles) {
  		o.move();
  	}
  }

  /**
   * Checks if the player collides with game obstacles.
   */
  public void checkCollisions() {
  	Rectangle player = frog.getBounds();

  	//If the player is on a log
  	if (frog.getY() < RIVER_STARTING_Y) {
  		boolean overLap = false;
  		for (GameObstacle o: obstacles) {
  			Rectangle obs = o.getBounds();
  			if (player.intersects(obs) && !o.isDangerous()) {
  				overLap = true;
  				if (o.getDirection() == 'R') {
  					frog.setX(frog.getX() + 1);
  				} else {
  					frog.setX(frog.getX() - 1);
  				}
  			}
  		}
  		if (!overLap) {
  			frog.die();
  		}
  	}

  	//If car hits player.
  	for (GameObstacle o : obstacles) {
  		Rectangle obs = o.getBounds();
  		if (player.intersects(obs) && o.isDangerous()) {
  			frog.die();
  		}
  	}
  }

  /**
   * Draws a box with a message inside it. Used to show win screen or game over.
   * @param g the graphics object
   * @param s The message inside the box.
   */
  private void showEndScreen(Graphics g, String s) {
  	Graphics2D g2d = (Graphics2D) g;

  	g2d.setColor(new Color(0, 32, 48));
  	g2d.fillRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);
  	g2d.setColor(Color.white);
  	g2d.drawRect(50, SCREEN_SIZE / 2 - 30, SCREEN_SIZE - 100, 50);

  	Font small = new Font("Helvetica", Font.BOLD, 14);
  	FontMetrics metr = this.getFontMetrics(small);

  	g2d.setColor(Color.white);
  	g2d.setFont(small);
  	g2d.drawString(s, (SCREEN_SIZE - metr.stringWidth(s)) / 2, SCREEN_SIZE / 2);
  }

  /**
   * Draws a the players current lives in bottom right of screen.
   * @param g2d the 2d graphics object
   */
  private void drawLives(Graphics2D g2d) {

  	String s;

  	g2d.setFont(smallFont);
  	g2d.setColor(new Color(0, 0, 0));
  	s = "Lives: " + frog.getLives();
  	g2d.drawString(s, SCREEN_SIZE - 80, SCREEN_SIZE - 40);
  }

  /**
   * Getter for keyManager
   * @return KeyManager the board's KeyManager
   */
  public KeyManager getKeyManager() {
  	return keyManager;
  }

  /**
   * Getter for screen size
   * @return the size of the screen in pixels.
   */
  public int getScreenSize() {
  	return SCREEN_SIZE;
  }
}
