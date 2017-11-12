import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyManager uses a boolean array where if the keys are pressed the boolean is set to true.
 */
public class KeyManager implements KeyListener {

    public boolean up, down, left, right;
    private boolean[] keys;

    /**
     * KeyManager default constructor.
     */
    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {

    }
}
