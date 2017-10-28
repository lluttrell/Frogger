import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * ImageLoader loads image for use in the game.
 */
public class ImageLoader {

  public static Image loadImage(String path) {
    try {
      return ImageIO.read(ImageLoader.class.getResource(path));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    return null;
  }
}
