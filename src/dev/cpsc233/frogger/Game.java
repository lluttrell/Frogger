package dev.cpsc233.frogger;

public class Game {
	public static void main(String[] args) {
		System.out.println("Welcome to Frogger\n");

		World world = new World();
		boolean done = false;
		
		while (!done) {
			System.out.println(world);
			done = world.movePlayer();

			if (done) {
				System.out.println("Game Over");
			}
		}
	}

}
