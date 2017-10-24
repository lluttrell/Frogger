public class World {
  // Constants
  private final int SCREEN_WIDTH = 14; // Columns
  private final int SCREEN_HEIGHT = 14; // Rows
  private final int FROG_STARTING_X = 6;
  private final int FROG_STARTING_Y = SCREEN_HEIGHT - 2;
  private final int RIVER_STARTING_Y = SCREEN_HEIGHT - 7;

  public int getScreenWidth() {
    return SCREEN_WIDTH;
  }

  public int getScreenHeight() {
    return SCREEN_HEIGHT;
  }

  public int getFrogStartingX() {
    return FROG_STARTING_X;
  }

  public int getFrogStartingY() {
    return FROG_STARTING_Y;
  }

  public int getRiverStartingY() {
    return RIVER_STARTING_Y;
  }

}
