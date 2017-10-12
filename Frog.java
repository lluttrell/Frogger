//package dev.cpsc233.frogger;

import java.util.Scanner;

public class Frog {
	//Instance Variable
	private int playerPosition = 6;

	public int getPosition() {
		return playerPosition;
	}

	/**
	 * movePlayer moves the player in the world and determines if the end is reached.
	 * @return boolean returns true if game is finished, otherwise false.
	 */

	public boolean movePlayer() {

		Scanner sc = new Scanner(System.in);
		String keyPressed = sc.nextLine();

		if (keyPressed.equals("w")) {
			playerPosition += 13;
			if (playerPosition > 169) {
				return true;
			}
		}else if (keyPressed.equals("s") && playerPosition >= 14) {
			playerPosition -= 13;
		}else if (keyPressed.equals("a")) {
			playerPosition -= 1;
		}else if (keyPressed.equals("d")) {
			playerPosition += 1;
		}else {
			System.out.println("\nPlease use wasd.");
		}
		return false;
	}
}
