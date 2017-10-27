import java.awt.image.BufferedImage;
import java.awt.Graphics;

/**
 * Tile class is a parent class to other tiles and handles
 * properties of a tile.
 */
public class Tile {

  //Tile array
  //TODO: maybe add more tiles?
  public static Tile[] tiles = new Tile[10];
  public static Tile metalTile = new MetalTile(0);

  //Class
  public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

  protected BufferedImage texture;
  protected final int id;

  /**
   * Default constructor.
   * @param texture the tile's texture.
   * @param id the tiles id to identify in an array.
   */
  public Tile(BufferedImage texture, int id) {
    this.texture = texture;
    this.id = id;

    tiles[id] = this;
  }

  public void tick() {

  }

  public void render(Graphics g, int x, int y) {
    g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
  }

  public boolean isSolid() {
    return false;
  }

  public int getId() {
    return id;
  }
}
