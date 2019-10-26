
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;


public class Controller implements KeyListener{
    final int SCREEN_WIDTH = 14;         // Columns
    final int SCREEN_HEIGHT = 14;         // Rows
    final int FROG_STARTING_X = 6;
    final int FROG_STARTING_Y = SCREEN_HEIGHT - 2;

    GameScreen screen=new GameScreen(SCREEN_WIDTH,SCREEN_HEIGHT);
    screen.InitScreen();

    Frog frog = new Frog('F', FROG_STARTING_X, FROG_STARTING_Y);

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_KP_UP || e.getKeyCode() == KeyEvent.VK_W) {
            frog.moveUp(screen, frog);

        } else if (e.getKeyCode() == KeyEvent.VK_KP_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            frog.moveDown(screen, frog);
        } else if (e.getKeyCode() == KeyEvent.VK_KP_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            frog.moveLeft(screen, frog);
        } else if (e.getKeyCode() == KeyEvent.VK_KP_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            frog.moveRight(screen, frog);
        } else {
            System.out.println("Please input wsad or uo down left right");
        }


    }

}
