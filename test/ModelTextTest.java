package test;

import frogger.model.Frog;
import frogger.model.GameObstacle;
import frogger.model.ModelText;
import frogger.util.CountdownTimer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ModelTextTest {

    @Test
    public void test_Constructor() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        assertEquals("Frog position", 4, f.getX(), 0.00001);
        assertEquals("Frog position", 5, f.getY(), 0.00001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithLogFromLeft() {

        Frog f = new Frog(10, 4);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 4, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        f.setX(2);
        modT.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithLogFromRight() {

        Frog f = new Frog(10, 4);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 4, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        f.setX(4);
        modT.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithLogFromBelow() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 4, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        f.setY(4);
        modT.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithLogFromAbove() {

        Frog f = new Frog(4, 3);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 4, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        f.setY(4);
        modT.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogDoesNotOverlapWithLog() {

        Frog f = new Frog(7, 3);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 5, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        modT.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogDoesNotOverlapWithCar() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 2, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        modT.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCarFromRight() {

        Frog f = new Frog(10, 2);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 2, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        f.setX(2);
        modT.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCarFromLeft() {

        Frog f = new Frog(10, 2);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 2, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        f.setX(4);
        modT.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCarFromAbove() {

        Frog f = new Frog(2, 1);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 2, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        f.setY(2);
        modT.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCarFromBelow() {

        Frog f = new Frog(2, 3);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new GameObstacle(3, 2, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);
        modT.updateObstacles();
        f.setY(2);
        modT.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_getRiverStartingY() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelText modT = new ModelText(f, obs, countdownTimer);

        assertEquals("Y coordinate where river starts should be 4", 4, modT.getRiverStartingY(), 0.000001);
    }

}