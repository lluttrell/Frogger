//package dev.cpsc233.frogger;

/**
 * @author Iden
 * World class controls game world and moving player.
 * Based on TA Zain Rizvi's Snakes and Ladders code.
 */

public class World {

	Frog frog = new Frog();
	//World dimensions
	private final int ROWS = 13;
	private final int COLS = 13;

	private int[][] gameWorld;

	//Default Constructor for World.
	public World(Frog frog) {
		this.frog = frog;
		gameWorld = new int[ROWS][COLS];
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				gameWorld[row][col] = row * ROWS + col + 1;
			}
		}
	}

	//toString method for printing world.
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int row = ROWS - 1; row >= 0; row--) {
			for (int col = 0; col < COLS; col++) {
				String pl = "";
				boolean occupied = false;
				if (frog.getPosition() == gameWorld[row][col]) {
					occupied = true;
					pl += "F" + " ";
				}

				if (occupied) {
					sb.append(pl);
				}else {
					sb.append("* ");
				}
			}
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}
}
