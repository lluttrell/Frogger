/**
 * Handles Car movement and initalization.
 * @author Iden Craven
 */

public class Car extends GameObstical {

  /**
  * Constructor for Car Object
  * @param length length of car
  * @param startingX initial x position
  * @param startingY initial y position
  */
  public Car(int length, int startingX, int startingY) {
    setSymbol('X');
    setX(startingX);
    setY(startingY);
    setLength(length);
  }
}
