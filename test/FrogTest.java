package test;
import frogger.model.Frog;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class FrogTest {

    @Test
    public void test_constructor() {
        Frog f = new Frog(1,1);
        assertEquals("Frog initial x position should be 1", 1, f.getX());
        assertEquals("Frog initial y position should be 1", 1, f.getY());
    }

    @Test
    public void test_move() {
        Frog f = new Frog(1,1);
        f.move(1,1);
        assertEquals("Frog x position should be 2",2,f.getX());

    }

    @Test
    public void test_getLives_intial() {
        Frog f = new Frog(1,1);
        assertEquals("Frog objects should initially have 3 lives", 3, f.getLives());
    }

    @Test
    public void test_getLives_after_die() {
        Frog f = new Frog(1,1);
        f.die();
        assertEquals("Frog objects should have 2 lives after dying", 2, f.getLives());
    }


    @Test
    public void test_getX() {
        Frog f = new Frog(1,1);
        f.setX(2);
        assertEquals("Frog x position should be 2", 2, f.getX());
    }

    @Test
    public void test_getY() {
        Frog f = new Frog(1,1);
        f.setY(2);
        assertEquals("Frog y position should be 2", 2, f.getY());
    }

    @Test
    public void test_x_position_after_die() {
        Frog f = new Frog(1,1);
        f.setX(2);
        f.die();
        assertEquals("Frog x position should reset after dying", 1, f.getX());
    }

    @Test
    public void test_y_position_after_die() {
        Frog f = new Frog(1,1);
        f.setY(2);
        f.die();
        assertEquals("Frog y position should reset after dying", 1, f.getY());
    }
}
