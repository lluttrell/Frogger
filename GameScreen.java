/**
 * Handles the screen dimensions and printing the screen.
 * @author Iden Craven
 * Adapted from console-snake; retrieved from https://github.com/andreirichkov/console-snake
 */

public class GameScreen {
  private int width, height;
  private char[][] screenMatrix;

  /**
   * Default constructor for GameScreen object
   * @param width Width of GameScreen
   * @param height Height of GameScreen
   */
  public GameScreen(int width, int height) {
  		this.width = width;
  		this.height = height;
  		this.screenMatrix = new char[this.height][this.width];
  }

  /**
   * Fills screenMatrix (play area) with default characters
   */
  public void InitScreen() {
  		for (int i = 0; i < this.height; i++) {
  				for (int j = 0; j < this.width; j++) {
  						this.screenMatrix[i][j] = '*';
  				}
  		}
  }

  /**
   * Prints the screenMatrix to the console
   */
  public void PrintScreen() {
  		for (int i = 0; i < this.height; i++) {
  				for (int j = 0; j < this.width; j++) {
  						System.out.print(this.screenMatrix[i][j] + " ");
  				}
  				System.out.println();
  		}
  }

  /**
   * Resets a character in the screenMatrix at a specified location to default.
   * @param x x coordinate
   * @param y y coordinate
   */
  public void ClearScreenLocation(int x, int y) {
  		this.screenMatrix[y][x] = '*';
  }

  // Getters
  /**
   * Returns the width of the screen
   * @return width of screen
   */
  public int getScreenWidth() {
  		return this.width;
  }

  /**
   * Returns the height of the screen
   * @return height of screen
   */
  public int getScreenHeight() {
  		return this.height;
  }

  /**
   * Returns the character at a certain position in the screenMatrix
   * @param x x position in screenMatrix
   * @param y y position in screenMatrix
   * @return character at specified location
   */
  public char getObjectOnLocation(int x, int y) {
  		return this.screenMatrix[y][x];
  }

  // Setters

  /**
   * Updates the character at a specified position in the screenMatrix to the
   * character used to represent a GameObject
   * @param object GameObject moving into the position
   * @param x x coordinate of GameObject
   * @param y y coordinate of GameObject
   */
  public void setObjectOnLocation(GameObject object, int x, int y) {
  		this.screenMatrix[y][x] = object.getSymbol();
  }
}
