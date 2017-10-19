public class Turtle extends GameObstical {
  
  /**
  * Constructor for Turtle Object
  * @param length length of turtle chain
  * @param startingX initial x position
  * @param startingY initial y position
  */
  public Turtle(int length, int startingX, int startingY) {
    setSymbol('L'); //symbol used to represent Log
    setX(startingX);
    setY(startingY);
    setLength(length);
  }
}
