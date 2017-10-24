/**
 * Handles log movement and initalization.
 * @author Iden Craven
 */

public class Log extends GameObstacle {

  /**
  * Constructor for Log Object
  * @param length length of log
  * @param startingX initial x position
  * @param startingY initial y position
  */
  public Log(int length, int startingX, int startingY) {
    setSymbol('L'); //symbol used to represent Log
    setX(startingX);
    setY(startingY);
    setLength(length);
    setDangerous(false);
  }
}
