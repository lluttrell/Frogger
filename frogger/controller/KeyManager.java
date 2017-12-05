package frogger.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyManager uses a boolean array where if a key is pressed it's corresponding entry is set to true, else it is false.
 */
public class KeyManager implements KeyListener {

    public boolean up, down, left, right, restartGame;
    private boolean[] keys;

    /**
     * KeyManager constructor.
     */
    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        restartGame = keys[KeyEvent.VK_X];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
