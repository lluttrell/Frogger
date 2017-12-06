package test;

import frogger.model.GameObstacle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameObstacleTest {

    @Test
    public void test_GUI_constructor() {
        GameObstacle g = new GameObstacle(1, 1, 'L', 100);
        assertEquals("Initial x position should be 1", 1, g.getX());
        assertEquals("Initial y position should be 1", 1, g.getY());
        assertEquals("Direction should be L", 'L', g.getDirection());
    }

    @Test
    public void test_text_constructor() {
        GameObstacle g = new GameObstacle(3, 1, 1, 'L', 100);
        assertEquals("Width should be 3", 3, g.getWidth());
        assertEquals("Initial x position should be 1", 1, g.getX());
        assertEquals("Initial y position should be 1", 1, g.getY());
        assertEquals("Direction should be L", 'L', g.getDirection());
    }

    @Test
    public void test_move_left() {
        GameObstacle g = new GameObstacle(2, 2, 'L', 100);
        g.move();
        assertEquals("Moved left, x position should change by one", 1, g.getX());
    }

    @Test
    public void test_move_right() {
        GameObstacle g = new GameObstacle(1, 1, 'R', 100);
        g.move();
        assertEquals("Moved right, x position should change by one", 2, g.getX());
    }

    @Test
    public void test_isDangerous_setDangerous() {
        GameObstacle g = new GameObstacle(1, 1, 'L', 100);
        g.setDangerous(true);
        assertEquals("Set danger to true", true, g.isDangerous());
    }

}
