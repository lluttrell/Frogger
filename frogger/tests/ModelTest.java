import frogger.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ModelTest {

    @Test
    public void test_updateFrog_FrogReachedEnd() {

        Frog f = new Frog(4, 5);
        ControllerText ct = new ControllerText();
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        ModelText modT = new ModelText(f, obs, ct);
        f.setY(0);
        modT.updateFrog();
        Assert.assertEquals("Running Should be set to false", false, ct.getRunning());
        Assert.assertEquals("Won should be set to True", true, ct.getWon());
    }

    @Test
    public void test_updateFrog_FrogNotReachedEnd() {

        Frog f = new Frog(4, 5);
        ControllerText ct = new ControllerText();
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        ModelText modT = new ModelText(f, obs, ct);
        f.setY(8);
        modT.updateFrog();
        Assert.assertEquals("Running Should be true", true, ct.getRunning());
        Assert.assertEquals("Won should be false", false, ct.getWon());
    }

    @Test
    public void test_updateFrog_FrogNotDead() {

        Frog f = new Frog(4, 5);
        ControllerText ct = new ControllerText();
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        ModelText modT = new ModelText(f, obs, ct);
        f.die();
        modT.updateFrog();
        Assert.assertEquals("Running Should be true", true, ct.getRunning());
    }

    @Test
    public void test_updateFrog_FrogDead() {

        Frog f = new Frog(4, 5);
        ControllerText ct = new ControllerText();
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        ModelText modT = new ModelText(f, obs, ct);
        f.die();
        f.die();
        f.die();
        modT.updateFrog();
        Assert.assertEquals("Running Should be set to false", false, ct.getRunning());
    }

    @Test
    public void test_updateObstacles() {

        Frog f = new Frog(4, 5);
        ControllerText ct = new ControllerText();
        ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();

        obs.add(new Log(3, 2, 'L', 15));
        obs.add(new Log(3, 2, 'R', 15));
        obs.add(new Log(6, 2, 'L', 15));
        obs.add(new Car(8, 4, 'R', 15));

        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles();

        Assert.assertEquals("first log position should be 2", 2, obs.get(0).getX(), 0.000001);
        Assert.assertEquals("second log position should be 2", 4, obs.get(1).getX(), 0.000001);
        Assert.assertEquals("third log position should be 2", 5, obs.get(2).getX(), 0.000001);
        Assert.assertEquals("First car position should be 2", 9, obs.get(3).getX(), 0.000001);
    }

}
