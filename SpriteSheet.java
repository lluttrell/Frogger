import java.awt.image.BufferedImage;

/**
 * Allows an image to be used as a SpriteSheet for improved efficiency.
 */
public class SpriteSheet {

  private BufferedImage sheet;

  public SpriteSheet(BufferedImage sheet) {
    this.sheet = sheet;
  }

  /**
   * Used to crop the individual sprites out of the spritesheet.
   * @param x the x co-ordinate of the edge of the image.
   * @param y the y co-ordinate of the top of the image.
   * @param width the width of the image in pixels.
   * @param height the height of the image in pixels.
   * @return BufferedImage the cropped sprite image.
   */
  public BufferedImage crop(int x, int y, int width, int height) {
    return sheet.getSubimage(x, y, width, height);
  }
}
