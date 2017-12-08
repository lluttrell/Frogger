package test;

import frogger.model.Frog;
import frogger.model.GameObstacle;
import frogger.model.ModelGUI;
import frogger.util.CountdownTimer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ModelGUITest {

    @Test
    public void test_Constructor() {

        Frog f = new Frog(4, 5);
        ArrayList<GameObstacle> obs = new ArrayList<>();
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        assertEquals("Frog position", 4, f.getX(), 0.00001);
        assertEquals("Frog position", 5, f.getY(), 0.00001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithLogFromRight() {

        Frog f = new Frog(4, 200);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        obs.add(new GameObstacle(3, 200, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        f.setX(2);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithLogFromLeft() {

        Frog f = new Frog(4, 200);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        obs.add(new GameObstacle(3, 200, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        f.setX(5);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithLogFromBelow() {

        Frog f = new Frog(4, 201);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        obs.add(new GameObstacle(3, 200, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        f.setY(200);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithLogFromAbove() {

        Frog f = new Frog(4, 199);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        obs.add(new GameObstacle(3, 200, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        f.setY(200);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogDoesNotOverlapWithLog() {

        Frog f = new Frog(7, 100);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        obs.add(new GameObstacle(3, 200, 'L', 15));
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        modGUI.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogDoesNotOverlapWithCar() {

        Frog f = new Frog(4, 250);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        GameObstacle car = new GameObstacle(3, 2, 'L', 240);
        car.setImage("/images/asteroid.png");
        car.getImageDimensions();
        car.setDangerous(true);
        obs.add(car);
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        modGUI.checkCollisions();

        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCarFromRight() {

        Frog f = new Frog(10, 250);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        GameObstacle car = new GameObstacle(3, 250, 'L', 15);
        car.setImage("/images/asteroid.png");
        car.getImageDimensions();
        car.setDangerous(true);
        obs.add(car);
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        f.setX(3);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCarFromLeft() {

        Frog f = new Frog(1, 250);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        GameObstacle car = new GameObstacle(3, 250, 'L', 15);
        car.setImage("/images/asteroid.png");
        car.getImageDimensions();
        car.setDangerous(true);
        obs.add(car);
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        f.setX(3);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCarFromAbove() {

        Frog f = new Frog(3, 249);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        GameObstacle car = new GameObstacle(3, 250, 'L', 15);
        car.setImage("/images/asteroid.png");
        car.getImageDimensions();
        car.setDangerous(true);
        obs.add(car);

        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        f.setY(250);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

    @Test
    public void test_checkCollision_FrogOverlapsWithCarFromBelow() {

        Frog f = new Frog(2, 251);
        f.getImageDimensions();
        ArrayList<GameObstacle> obs = new ArrayList<>();

        GameObstacle car = new GameObstacle(3, 250, 'L', 15);
        car.setImage("/images/asteroid.png");
        car.getImageDimensions();
        car.setDangerous(true);
        obs.add(car);
        CountdownTimer countdownTimer = new CountdownTimer();

        ModelGUI modGUI = new ModelGUI(f, obs, countdownTimer);
        modGUI.updateObstacles();
        f.setY(250);
        modGUI.checkCollisions();

        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
    }

}