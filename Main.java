import java.util.Scanner;

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
		Wall wall = new Wall('#');
		wall.addWallsRow(screen, wall, 0); // First row
		wall.addWallsRow(screen, wall, screen.getScreenHeight() - 1); // Last row
		wall.addWallsColumn(screen, wall, 0); // First column
		wall.addWallsColumn(screen, wall, screen.getScreenWidth() - 1); // Last column

		// Init player
		Frog frog = new Frog('F', FROG_STARTING_X, FROG_STARTING_Y);
		screen.setObjectOnLocation(frog, frog.getX(), frog.getY());

		// Input from player
		Scanner scanner = new Scanner(System.in);
		char input;

		// The game logic starts here
		boolean isRunning = true;

		while (isRunning) {
			screen.PrintScreen();
			// Get input from player and do something
			switch (input = scanner.nextLine().charAt(0)) {
			case 'a':
				frog.moveLeft(screen, frog);
				break;
			case 'd':
				frog.moveRight(screen, frog);
				break;
			case 'w':
				frog.moveUp(screen, frog);
				break;
			case 's':
				frog.moveDown(screen, frog);
				break;
			}
		}
	}
}
