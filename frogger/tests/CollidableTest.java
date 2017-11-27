import frogger.Collidable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollidableTest {

    @Test
    public void test_GUI_constructor() {
        Collidable c = new Collidable(1, 1, 'L', 160);
        assertEquals("xStartingLocation should be 1", 1, c.getX());
        assertEquals("yStartingLocation should be 1", 1, c.getY());
        assertEquals("direction should be L", 'L', c.getDirection());
        assertEquals("car obstacles should be dangerous", true, c.isDangerous());
    }

    @Test
    public void test_text_constructor() {
        Collidable c = new Collidable(3, 1, 1, 'L', 160);
        assertEquals("width should be 3", 3, c.getWidth());
        assertEquals("xStartingLocation should be 1", 1, c.getX());
        assertEquals("yStartingLocation should be 1", 1, c.getY());
        assertEquals("direction should be L", 'L', c.getDirection());
        assertEquals("car symbol should be X", 'X', c.getSymbol());
        assertEquals("car obstacles should be dangerous", true, c.isDangerous());
    }

}
