package test;

import frogger.model.GameObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameObjectTest {

    @Test
    public void test_setX_getX() {
        GameObject g = new GameObject(1, 1);
        g.setX(2);
        assertEquals("x should have a value of 2", 2, g.getX());
    }

    @Test
    public void test_setY_getY() {
        GameObject g = new GameObject(1, 1);
        g.setY(2);
        assertEquals("y should have a value of 2", 2, g.getY());
    }

    @Test
    public void test_default_constructor() {
        GameObject g = new GameObject(1, 1);
        assertEquals("x should have a value of 1", 1, g.getX());
        assertEquals("y should have a value of 1", 1, g.getY());
    }

    @Test
    public void test_text_constructor() {
        GameObject g = new GameObject(1, 1, 1);
        assertEquals("x should have a value of 1", 1, g.getX());
        assertEquals("y should have a value of 1", 1, g.getY());
        assertEquals("width should be 1", 1, g.getWidth());
    }

    @Test
    public void test_setSymbol_getSymbol() {
        GameObject g = new GameObject(1, 1);
        g.setSymbol('x');
        assertEquals("Symbol should be x", 'x', g.getSymbol());
    }
}
