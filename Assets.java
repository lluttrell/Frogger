import java.awt.image.BufferedImage;

public class Assets {

  private static final int width = 32, height = 32;

  public static BufferedImage frog, car;

  public static void init() {
    SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/frogsprite.png"));

    frog = sheet.crop(0, 0, width, height);
    car = sheet.crop(width, 0, width, height);
  }
}
