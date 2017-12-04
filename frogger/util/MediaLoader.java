package frogger.util;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * MediaLoader loads media for use in the game.
 */
public class MediaLoader {

    /**
     * Loads an image for use in the game.
     *
     * @param path The path to the image file.
     * @return The image specified.
     */
    public static Image loadImage(String path) {
        try {
            return ImageIO.read(MediaLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    /**
     * Plays game sounds.
     */
    public static void playSound(String path) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
