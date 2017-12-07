package test;
import frogger.model.GameObstacle;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameObstacleTest {

    @Test
    public void test_GUI_constructor() {
        GameObstacle g = new GameObstacle(1,1,'L',100);
        assertEquals("Initial x position should be 1", 1, g.getX());
        assertEquals("Initial y position should be 1", 1, g.getY());
        assertEquals("Direction should be L", 'L', g.getDirection());
    }

    @Test
    public void test_text_constructor() {
        GameObstacle g = new GameObstacle(3,1,1,'L',100);
        assertEquals("Width should be 3", 3, g.getWidth());
        assertEquals("Initial x position should be 1", 1, g.getX());
        assertEquals("Initial y position should be 1", 1, g.getY());
        assertEquals("Direction should be L", 'L', g.getDirection());
    }

    @Test
    public void test_move_left() {
        GameObstacle g = new GameObstacle(2,2,'L',100);
        g.move();
        assertEquals("Moved left, x position should change by one", 1, g.getX());
    }

    @Test
    public void test_move_left_off_board() {
        GameObstacle g = new GameObstacle(-122,2,'L',100);
        g.move();
        assertEquals("Moved left off screen, object should wrap to other side", 101, g.getX());
    }

    @Test
    public void test_move_left_starting_offScreen() {
        GameObstacle g = new GameObstacle(-1000,2,'L',100);
        g.move();
        assertEquals("Moved left off screen, object should wrap to other side", 101, g.getX());
    }

    @Test
    public void test_move_right() {
        GameObstacle g = new GameObstacle(1,1,'R',100);
        g.move();
        assertEquals("Moved right, x position should change by one", 2, g.getX());
    }

    @Test
    public void test_move_right_off_board() {
        GameObstacle g = new GameObstacle(98,2,'R',100);
        g.move();
        assertEquals("Moved right off screen, object should wrap to other side", 1, g.getX());
    }

    @Test
    public void test_move_right_starting_offScreen() {
        GameObstacle g = new GameObstacle(2000,2,'R',100);
        g.move();
        assertEquals("Obstacle should move back onto board", 1,g.getX());
    }

    @Test
    public void test_move_above_screen() {
        GameObstacle g = new GameObstacle(2,100,'R',100);
        g.move();
        assertEquals("Obstacle should move to x=3",3,g.getX());
    }

    @Test
    public void test_move_below_screen() {
        GameObstacle g = new GameObstacle(2,-1000,'R',100);
        g.move();
        assertEquals("Obstacle should move to x=3",3,g.getX());
    }

    @Test
    public void test_isDangerous_setDangerousTrue() {
        GameObstacle g = new GameObstacle(1,1,'L',100);
        g.setDangerous(true);
        assertEquals("Set danger to true", true, g.isDangerous());
    }

    @Test
    public void test_isDangerous_setDangerousFalse() {
        GameObstacle g = new GameObstacle(1,1,'L',100);
        g.setDangerous(false);
        assertEquals("Set danger to false", false, g.isDangerous());
    }
}
