
import static org.junit.Assert.*;

//import frogger.Frog;

import org.junit.Test;

import java.util.ArrayList;


public class ModelTextTest {
    
	@Test
    public void test_Constructor(){
		
		Frog f = new Frog(4, 5);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
        ModelText modT = new ModelText(f, obs, ct);
        assertEquals("Frog position", 4, f.getX(), 0.00001);
        assertEquals("Frog position", 5, f.getY(), 0.00001);
	} 

	
	@Test
    public void test_checkCollision_FrogOverlapsWithLogFromLeft(){
		
		Frog f = new Frog(10, 4);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Log(3,4,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        f.setX(2);
        modT.checkCollisions();
        
        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
	}
	
	@Test
    public void test_checkCollision_FrogOverlapsWithLogFromRight(){
		
		Frog f = new Frog(10, 4);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Log(3,4,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        f.setX(4);
        modT.checkCollisions();
        
        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
	}
	
	@Test
    public void test_checkCollision_FrogOverlapsWithLogFromBelow(){
		
		Frog f = new Frog(4, 5);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Log(3,4,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        f.setY(4);
        modT.checkCollisions();
        
        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
	}
	
	@Test
    public void test_checkCollision_FrogOverlapsWithLogFromAbove(){
		
		Frog f = new Frog(4, 3);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Log(3,4,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        f.setY(4);
        modT.checkCollisions();
        
        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
	}
	
	@Test
    public void test_checkCollision_FrogDoesNotOverlapWithLog(){
		
		Frog f = new Frog(7, 3);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Log(3,5,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        modT.checkCollisions();
        
        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
	}
	
	@Test
    public void test_checkCollision_FrogDoesNotOverlapWithCar(){
		
		Frog f = new Frog(4, 5);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Car(3,2,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        modT.checkCollisions();
        
        assertEquals("Frog's lives should still be 3", 3, f.getLives(), 0.000001);
	}
	
	@Test
    public void test_checkCollision_FrogOverlapsWithCarFromRight(){
		
		Frog f = new Frog(10, 2);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Car(3,2,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        f.setX(2);
        modT.checkCollisions();
        
        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
	}
	
	@Test
    public void test_checkCollision_FrogOverlapsWithCarFromLeft(){
		
		Frog f = new Frog(10, 2);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Car(3,2,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        f.setX(4);
        modT.checkCollisions();
        
        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
	}
	
	@Test
    public void test_checkCollision_FrogOverlapsWithCarFromAbove(){
		
		Frog f = new Frog(3, 1);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Car(3,2,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        f.setY(2);
        modT.checkCollisions();
        
        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
	}
	
	@Test
    public void test_checkCollision_FrogOverlapsWithCarFromBelow(){
		
		Frog f = new Frog(3,3);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
		
		obs.add(new Car(3,2,'L', 15));
		
        ModelText modT = new ModelText(f, obs, ct);
        modT.updateObstacles(); 
        f.setY(2);
        modT.checkCollisions();
        
        assertEquals("Frog's lives should be 2", 2, f.getLives(), 0.000001);
	}
	
	@Test
	public void test_getRiverStartingY() {
		
		Frog f = new Frog(4, 5);
		ControllerText ct = new ControllerText();
		ArrayList<GameObstacle> obs = new ArrayList<GameObstacle>();
	    
	    ModelText modT = new ModelText(f, obs, ct);
	    
	    assertEquals("Y coordinate where river starts should be 4", 4, modT.getRiverStartingY(), 0.000001);
    }
	
}