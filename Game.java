import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

  private Display display;
  public int width;
  public int height;
  public String title;

  private boolean running = false;
  private Thread thread;

  private BufferStrategy bs;
  private Graphics g;

  //States
  private State gameState;
  private State menuState;

  //Input
  private KeyManager keyManager;

  /**
   * Game default constructor
   * @param title Window's title
   * @param width Window's width
   * @param height Window's height
   */
  public Game(String title, int width, int height) {
  		this.width = width;
  		this.height = height;
  		this.title = title;
  		keyManager = new KeyManager();
  }

  /**
   * Initializes states, display, and assets.
   */
  private void init() {
  		display = new Display(title, width, height);
  		display.getFrame().addKeyListener(keyManager);
  		Assets.init();

  		//initialize states
  		gameState = new GameState(this);
  		menuState = new MenuState(this);
  		State.setState(gameState);
  }

  /**
   * Ticks the state.
   */
  private void tick() {
  		keyManager.tick();
      
  		if(State.getState() != null) {
  				State.getState().tick();
  		}
  }

  /**
   * Handles display and rendering.
   */
  private void render() {
  		bs = display.getCanvas().getBufferStrategy();
  		if(bs == null) {
  				display.getCanvas().createBufferStrategy(3);
  				return;
  		}
  		g = bs.getDrawGraphics();
  		//Clear screen
  		g.clearRect(0, 0, width, height);
  		//Draw here

  		//Renders state if it's not empty
  		if(State.getState() != null) {
  				State.getState().render(g);
  		}

  		//End drawing
  		bs.show();
  		g.dispose();
  }

  /**
   * Handles game speed and game loop.
   */
  public void run() {
  		init();

  		int fps = 60;
  		//1000000000 nanoseconds = 1 second
  		//timePerTick is maximum amount of time a tick can last
  		double timePerTick = 1000000000 / fps;
  		double delta = 0;
  		long now;
  		long lastTime = System.nanoTime();
  		long timer = 0;
  		int ticks = 0;

  		while(running) {
  				//Current time in nanoseconds.
  				now = System.nanoTime();
  				//now - lastTime is the amount of time passed
  				//delta is when we can call tick and render methods.
  				delta += (now - lastTime) / timePerTick;
  				timer += now - lastTime;
  				lastTime = now;

  				//To make game run at 60fps on all computers.
  				if(delta >= 1) {
  						tick();
  						render();
  						ticks++;
  						delta--;
  				}

  				//Frame Counter
  				if (timer >= 1000000000) {
  						System.out.println("Ticks and Frames:" + ticks);
  						ticks = 0;
  						timer = 0;
  				}
  		}
  		stop();
  }

  /**
   * Getter for keyManager
   * @return KeyManager the game class's keyManager object.
   */
  public KeyManager getKeyManager() {
  		return keyManager;
  }


  /**
   * Starts thread
   */
  public synchronized void start() {
  		//Check if already running.
  		if(running) {
  				return;
  		}
  		running = true;
  		thread = new Thread(this);
  		thread.start();
  }

  /**
   * Stops thread
   */
  public synchronized void stop() {
  		//Check if already not running.
  		if(!running) {
  				running = false;
  		}
  		try {
  				thread.join();
  		} catch (InterruptedException e) {
  				e.printStackTrace();
  		}
  }
}
