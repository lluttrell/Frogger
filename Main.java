import java.util.Scanner;

/**
 * Main class handles running the Frogger game.
 * @author Iden Craven
 * Adapted from console-snake; retrieved from https://github.com/andreirichkov/console-snake
 */

public class Main {
	public static void main(String[] args) {

		System.out.println("Welcome to Frogger\n");

		// Constants
		final int SCREEN_WIDTH = 14; // Columns
		final int SCREEN_HEIGHT = 14; // Rows
		final int FROG_STARTING_X = 6;
		final int FROG_STARTING_Y = SCREEN_HEIGHT - 2;
		final int RIVER_STARTING_Y = SCREEN_HEIGHT - 7;

		// Init screen
		GameScreen screen = new GameScreen(SCREEN_WIDTH, SCREEN_HEIGHT);

		//Init player
		Frog frog = new Frog('F', FROG_STARTING_X, FROG_STARTING_Y);

		//Init obstacles
		Car car1 = new Car(3, screen.getScreenWidth() - 3, 10);
		Car car2 = new Car(2, screen.getScreenWidth() - 4, 8);
		Log log1 = new Log(3, screen.getScreenWidth() - 3, RIVER_STARTING_Y);
		Wall wall = new Wall();
		wall.addWallsRow(screen, wall, 0); // First row
		wall.addWallsRow(screen, wall, screen.getScreenHeight() - 1); // Last row
		wall.addWallsColumn(screen, wall, 0); // First column
		wall.addWallsColumn(screen, wall, screen.getScreenWidth() - 1); // Last column
		GameObject[] gameObjects = {wall,car1,car2,log1};

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
			} else if (keyPressed == 's' && frog.getY() < FROG_STARTING_Y) {
				frog.moveDown(frog);
			} else if (keyPressed == 'a' && frog.getX()  > SCREEN_WIDTH - (SCREEN_WIDTH - 1)) {
				frog.moveLeft(frog);
			}else if (keyPressed == 'd' && frog.getX() < SCREEN_WIDTH - 2) {
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
				frog.setX(FROG_STARTING_X);
				frog.setY(FROG_STARTING_Y);
				screen.setObjectOnLocation(frog, frog.getX(), frog.getY());
				if (frog.getLives() == 0) {
					running = false;
					System.out.println("\n**GAME OVER**");
				}
			}

			// check if frog is in the river and if it overlaps with log. Kill
			// frog if it doesn't
			if (frog.getY() == RIVER_STARTING_Y && !log1.overlapsWith(frog)) {
				frog.die();
				screen.ClearScreenLocation(frog.getX(),frog.getY());
				frog.setX(FROG_STARTING_X);
				frog.setY(FROG_STARTING_Y);
				screen.setObjectOnLocation(frog, frog.getX(), frog.getY());
				if (frog.getLives() == 0) {
					running = false;
					System.out.println("\n**GAME OVER**");
				}
			}

			// reset car to right side of screen if it hits the wall
			if (car1.getX() > SCREEN_WIDTH - (SCREEN_WIDTH - 2)) {
				car1.moveLeft(screen, car1);
			} else { //Car hits left wall
				car1.resetRight(screen, car1, wall);
			}

			// reset log to right side of screen if it hits the wall
			if (log1.getX() > SCREEN_WIDTH - (SCREEN_WIDTH - 2)) {
				log1.moveLeft(screen, log1);
			} else { //Log hits left wall
				log1.resetRight(screen, log1, wall);
			}
		}
	}
}
