import frogger.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ModelGUITest {

    @Test
    public void test_Constructor() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        ModelGUI modGUI = new ModelGUI(f, obs);
        assertEquals("Frog position", 4, f.getX(), 0.00001);
        assertEquals("Frog position", 5, f.getY(), 0.00001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithLog() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new Platform(3, 200, 'L', 15));

        ModelGUI modGUI = new ModelGUI(f, obs);
        modGUI.updateObstacles();
        f.setX(2);
        f.setY(200);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogDoesNotOverlapWithLog() {

        Frog f = new Frog(7, 190);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new Platform(3, 200, 'L', 15));

        ModelGUI modGUI = new ModelGUI(f, obs);
        modGUI.updateObstacles();
        modGUI.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogDoesNotOverlapWithCar() {

        Frog f = new Frog(4, 250);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new Collidable(3, 2, 'L', 240));

        ModelGUI modGUI = new ModelGUI(f, obs);
        modGUI.updateObstacles();
        modGUI.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCar() {

        Frog f = new Frog(2, 201);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new Collidable(3, 201, 'L', 15));

        ModelGUI modGUI = new ModelGUI(f, obs);
        modGUI.updateObstacles();
        f.setX(44);
        f.setY(201);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

}
