import frogger.Frog;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrogTest {

    @Test
    public void test_GUI_constructor() {
        Frog f = new Frog(1, 1);
        assertEquals("frogger.Frog initial x position should be 1", 1, f.getX());
        assertEquals("frogger.Frog initial y position should be 1", 1, f.getY());
    }

 /* @Test
  public void test_text_constructor() {
    frogger.Frog f = new frogger.Frog(1,1,1);
    assertEquals("frogger.Frog width should be 1", 1, f.getWidth());
    assertEquals("frogger.Frog initial x position should be 1", 1, f.getX());
    assertEquals("frogger.Frog initial y position should be 1", 1, f.getY());
  }*/

    @Test
    public void test_getLives_initial() {
        Frog f = new Frog(1, 1);
        assertEquals("frogger.Frog objects should initially have 3 lives", 3, f.getLives());
    }

    @Test
    public void test_getLives_after_die() {
        Frog f = new Frog(1, 1);
        f.die();
        assertEquals("frogger.Frog objects should have 2 lives after dying", 2, f.getLives());
    }

    @Test
    public void test_getLives_negative_lives() {
        Frog f = new Frog(1, 1);
        for (int i = 0; i < 4; i++) {
            f.die();
        }
        assertEquals("frogger.Frog objects should not have negative lives", 0, f.getLives());
    }

    @Test
    public void test_getX() {
        Frog f = new Frog(1, 1);
        f.setX(2);
        assertEquals("frogger.Frog x position should be 2", 2, f.getX());
    }

    @Test
    public void test_getY() {
        Frog f = new Frog(1, 1);
        f.setY(2);
        assertEquals("frogger.Frog y position should be 2", 2, f.getY());
    }

    @Test
    public void test_x_position_after_die() {
        Frog f = new Frog(1, 1);
        f.setX(2);
        f.die();
        assertEquals("frogger.Frog x position should reset after dying", 1, f.getX());
    }

    @Test
    public void test_y_position_after_die() {
        Frog f = new Frog(1, 1);
        f.setY(2);
        f.die();
        assertEquals("frogger.Frog y position should reset after dying", 1, f.getY());
    }

}
