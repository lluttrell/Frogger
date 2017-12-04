package frogger.graphics;

import java.awt.image.BufferedImage;

/**
 * Animation iterates through an array of buffered images to create animation.
 */
public class Animation {

    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    /**
     * Constructor for Animation
     *
     * @param speed  the speed in milliseconds that the animation plays at.
     * @param frames An array of Buffered Images which contain the animation frames.
     */
    public Animation(int speed, BufferedImage[] frames) {
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    /**
     * Getter for current frame that is queued.
     *
     * @return The Buffered Image that is at the current index in the frames array.
     */
    public BufferedImage getCurrentFrame() {
        return frames[index];
    }

    /**
     * Ticks the animation based on the speed given.
     */
    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed) {
            index++;
            timer = 0;
            if (index >= frames.length)
                index = 0;
        }
    }
}
