public class Car extends GameObject {

  private int length;

  public Car(int length, int startingX, int startingY) {
    setSymbol('X');
    setX(startingX);
    setY(startingY);
    this.length = length;
  }

  public void initCar(GameScreen screen, Car car) {
    for (int i = getX() - 1 ; i < (getX() - 1) + this.length; i++) {
		    screen.setObjectOnLocation(car, i, car.getY());
    }
  }

  public void moveLeft(GameScreen screen, Car car) {
		car.setX(getX() - 1);
    for (int i = getX() - 1 ; i < (getX() - 1) + this.length; i++) {
		    screen.setObjectOnLocation(car, i, car.getY());
    }
		screen.ClearScreenLocation(car.getX() + 2, car.getY());
	}

  public void moveRight(GameScreen screen, Car car) {
		car.setX(getX() + 1);
		screen.setObjectOnLocation(car, car.getX(), car.getY());
		screen.ClearScreenLocation(car.getX() - 1, car.getY());
	}
}
