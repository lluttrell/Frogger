import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Tile {

  public static final int TILEWIDTH =32, TILEHEIGHT = 32;

  protected BufferedImage texture;
  protected final int id;

  public Tile(BufferedImage texture, int id) {
    this.texture = texture;
    this.id = id;
  }

  public void tick() {

  }

  public void render(Graphics g, int x, int y) {
    g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
  }

  public int getId() {
    return id;
  }
}
