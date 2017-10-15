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

		// Init screen
		GameScreen screen = new GameScreen(SCREEN_WIDTH, SCREEN_HEIGHT);
		screen.InitScreen();

		// Init walls
		Wall wall = new Wall();
		wall.addWallsRow(screen, wall, 0); // First row
		wall.addWallsRow(screen, wall, screen.getScreenHeight() - 1); // Last row
		wall.addWallsColumn(screen, wall, 0); // First column
		wall.addWallsColumn(screen, wall, screen.getScreenWidth() - 1); // Last column

		// Init player & cars
		Frog frog = new Frog('F', FROG_STARTING_X, FROG_STARTING_Y);
		screen.setObjectOnLocation(frog, frog.getX(), frog.getY());
		Car car1 = new Car(3, screen.getScreenWidth() - 3, 4);
		car1.initCar(screen, car1);
		// Input from player
		Scanner scanner = new Scanner(System.in);
		char input;

		// The game logic starts here
		boolean running = true;

		//Game loop & logic
		while (running) {
			screen.PrintScreen();
			// Get input from player and do something
			char keyPressed = scanner.nextLine().charAt(0);
			if (keyPressed == 'w') {
				frog.moveUp(screen, frog);
				if (frog.getY() < 1) {
					running = false;
					System.out.println("\n**YOU WIN**");
				}
			}else if (keyPressed == 's' && frog.getY() < FROG_STARTING_Y) {
				frog.moveDown(screen, frog);
			}else if (keyPressed == 'a' && frog.getX()  > SCREEN_WIDTH - (SCREEN_WIDTH - 1)) {
				frog.moveLeft(screen, frog);
			}else if (keyPressed == 'd' && frog.getX() < SCREEN_WIDTH - 2) {
				frog.moveRight(screen, frog);
			}else {
				System.out.println("\nPlease use wasd or stay within game walls.");
			}
			if (car1.getX() > SCREEN_WIDTH - (SCREEN_WIDTH - 2)) {
				car1.moveLeft(screen, car1);
			}else {
				car1.resetRight(screen, car1, wall);
			}
		}
	}
}
