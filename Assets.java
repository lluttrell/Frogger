import java.awt.image.BufferedImage;

/**
 * Assets uses a SpriteSheet to crop image assets from it to improve effiency.
 */
public class Assets {

  private static final int width = 64, height = 64;

  public static BufferedImage frog, metal;

  /**
   * init loads a given spritesheet and crops assets from it.
   */
  public static void init() {
    SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/spritesheet.png"));

    frog = sheet.crop(0, 0, width, height);
    metal = sheet.crop(width, 0, width, height);
  }
}
