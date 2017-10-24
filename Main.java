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
		GameObstacle[] gameObstacles = {
		new River(world.getRiverStartingY()),
		new River(world.getRiverStartingY()- 1),
		new River(world.getRiverStartingY()- 2),
		new River(world.getRiverStartingY()- 3),
		new River(world.getRiverStartingY()- 4),
		new River(world.getRiverStartingY()- 5),
		new Car(3, screen.getScreenWidth() - 3, 10),
		new Car(2, screen.getScreenWidth() - 4, 8),
		new Log(3, screen.getScreenWidth() - 3, world.getRiverStartingY()),
		new Log(3, screen.getScreenWidth() - 4, world.getRiverStartingY()- 1),
		new Log(3, screen.getScreenWidth() - 5, world.getRiverStartingY()- 2)
	};

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
			} else if (keyPressed == 'd' && frog.getX() < world.getScreenWidth() - 2) {
				frog.moveRight(frog);
			} else {
				System.out.println("\nPlease use wasd or stay within game walls.");
			}

			screen.InitScreen();
			screen.printObjectsToScreen(gameObstacles,frog);
			screen.PrintScreen();

			// check if frog has made to to the finish area
			if (frog.getY() < 1) {
				running = false;
				System.out.println("\n**YOU WIN**");
			}

			// check if frog overlaps with dangerous obstacles. Kill it if it does.
			for (GameObstacle g: gameObstacles) {
				if (g.overlapsWith(frog) && g.isDangerous()) {
					frog.die();
					frog.setX(world.getFrogStartingX());
					frog.setY(world.getFrogStartingY());
				}
			}

			// move the obstacles
			for (GameObstacle g: gameObstacles) {
				g.moveObstacle(screen,g);
			}

			// check if frog is dead.
			if (frog.getLives() == 0) {
				running = false;
				System.out.println("\n**GAME OVER**");
			}
		}
	}
}
