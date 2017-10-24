import java.util.Scanner;

/**
 * Main class handles running the Frogger game.
 * @author Iden Craven
 * Adapted from console-snake; retrieved from https://github.com/andreirichkov/console-snake
 */

public class Main {
	public static void main(String[] args) {

		System.out.println("Welcome to Frogger\n");

		// create new world
		World world = new World();

		// Init screen
		GameScreen screen = new GameScreen(world.getScreenWidth(), world.getScreenHeight());

		//Init player
		Frog frog = new Frog('F', world.getFrogStartingX(), world.getFrogStartingY());

		//Init obstacles
		Car car1 = new Car(3, screen.getScreenWidth() - 3, 10);
		Car car2 = new Car(2, screen.getScreenWidth() - 4, 8);
		Log log1 = new Log(3, screen.getScreenWidth() - 3, world.getRiverStartingY());
		River river1 = new River(world.getRiverStartingY());
		Wall wall = new Wall();
		wall.addWallsRow(screen, wall, 0); // First row
		wall.addWallsRow(screen, wall, screen.getScreenHeight() - 1); // Last row
		wall.addWallsColumn(screen, wall, 0); // First column
		wall.addWallsColumn(screen, wall, screen.getScreenWidth() - 1); // Last column
		GameObject[] gameObjects = {river,car1,car2,log1};

		// Init walls


		// Input from player
		Scanner scanner = new Scanner(System.in);
		char input;

		// The game logic starts here
		boolean running = true;

		//Game loop & logic
		while (running) {
			System.out.println("Lives remaining:" + frog.getLives());

			// Get input from player and do something
			char keyPressed = scanner.nextLine().charAt(0);
			if (keyPressed == 'w') {
				frog.moveUp(frog);
			} else if (keyPressed == 's' && frog.getY() < world.getFrogStartingY()) {
				frog.moveDown(frog);
			} else if (keyPressed == 'a' && frog.getX()  > world.getScreenWidth() - (world.getScreenWidth() - 1)) {
				frog.moveLeft(frog);
			}else if (keyPressed == 'd' && frog.getX() < world.getScreenWidth() - 2) {
				frog.moveRight(frog);
			}else {
				System.out.println("\nPlease use wasd or stay within game walls.");
			}

			screen.InitScreen();
			screen.printObjectsToScreen(gameObjects,frog);
			screen.PrintScreen();

			// check if frog has made to to the finish area
			if (frog.getY() < 1) {
				running = false;
				System.out.println("\n**YOU WIN**");
			}

			// check if frog overlaps with car. Kill frog if it does.
			if (car1.overlapsWith(frog)) {
				frog.die();
				frog.setX(world.getFrogStartingX());
				frog.setY(world.getFrogStartingY());
			}

			// check if frog is in the river and if it overlaps with log. Kill
			// frog if it doesn't
			if (frog.getY() == world.getRiverStartingY() && !log1.overlapsWith(frog)) {
				frog.die();
				frog.setX(world.getFrogStartingX());
				frog.setY(world.getFrogStartingY());
			}

			if (frog.getLives() == 0) {
				running = false;
				System.out.println("\n**GAME OVER**");
			}
			car1.moveObstacle(screen,car1);
			car2.moveObstacle(screen,car2);
			log1.moveObstacle(screen,log1);
		}
	}
}
