/**
 * Handles setting walls around the GameScreen.
 * @author andreirichkov
 * retrieved from https://github.com/andreirichkov/console-snake
 */

public class Wall extends GameObject {

	/**
	* Default constructor. Sets symbol to '#'
	*/
	public Wall() {
		setSymbol('#');
	}

	/**
	* Constructor for Wall
	* @param symbol Character used to represent the wall
	*/
	public Wall(char symbol) {
		setSymbol(symbol);
	}

	/**
	* Adds horizontal line of walls to GameScreen
	* @param screen GameScreen to draw Wall on
	* @param wall Wall to draw on GameScreen
	* @param rowNumber Row on gamescreen to draw wall to
	*/
	public void addWallsRow(GameScreen screen, Wall wall, int rowNumber) {
		for (int i = 0; i < screen.getScreenWidth(); i++) {
			screen.setObjectOnLocation(wall, i, rowNumber);
		}
	}

	/**
	* Adds vertical line of wall to GameScreen
	* @param screen GameScreen to draw Wall on
	* @param wall Wall to draw on GameScreen
	* @param columnNumber Column on gamescreen to draw wall to
	*/
	public void addWallsColumn(GameScreen screen, Wall wall, int columnNumber) {
		for (int i = 0; i < screen.getScreenHeight(); i++) {
			screen.setObjectOnLocation(wall, columnNumber, i);
		}
	}
}
