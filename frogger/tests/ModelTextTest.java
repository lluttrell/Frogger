import frogger.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ModelTextTest {

    @Test
    public void test_Constructor() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        ModelText modT = new ModelText(f, obs);
        assertEquals("Frog position", 4, f.getX(), 0.00001);
        assertEquals("Frog position", 5, f.getY(), 0.00001);
    }


    @Test
    public void test_checkCollision_FrogOverlapsWithLog() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new Platform(3, 4, 'L', 15));

        ModelText modT = new ModelText(f, obs);
        modT.updateObstacles();
        f.setX(2);
        f.setY(4);
        modT.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogDoesNotOverlapWithLog() {

        Frog f = new Frog(7, 3);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new Platform(3, 5, 'L', 15));

        ModelText modT = new ModelText(f, obs);
        modT.updateObstacles();
        modT.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogDoesNotOverlapWithCar() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new Collidable(3, 2, 'L', 15));

        ModelText modT = new ModelText(f, obs);
        modT.updateObstacles();
        modT.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCar() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new Collidable(3, 2, 'L', 15));

        ModelText modT = new ModelText(f, obs);
        modT.updateObstacles();
        f.setX(2);
        f.setY(2);
        modT.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

	
	/*@Test
    public void test_overlapsWith_FrogOverlapsWithCar(){
		
		Frog f = new Frog(4, 5);
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		Collidable c1 = new Collidable(3,2,'L', 15);
		
        ModelText modT = new ModelText(f, obs);
        f.setX(3);
        f.setY(2);
        
        assertEquals("Frog overlaps with car", true, modT.overlapsWith(c1));
	}*/

    @Test
    public void test_getRiverStartingY() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        ModelText modT = new ModelText(f, obs);

        assertEquals("Y coordinate where river starts should be 4", 4, modT.getRiverStartingY(), 0.000001);
    }
}