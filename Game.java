//package dev.cpsc233.frogger;

 /**
  * @author Iden
	* Main Class for Frogger game.
  */

public class Game {
	public static void main(String[] args) {
		//Welcome message
		System.out.println("Welcome to Frogger\n");

		//Instatiate Objects
		Frog frog = new Frog();
		World world = new World(frog);
		boolean done = false;

		//Game loop
		while (!done) {
			System.out.println(world);
			done = frog.movePlayer();

			if (done) {
				System.out.println("Game Over");
			}
		}
	}

}
