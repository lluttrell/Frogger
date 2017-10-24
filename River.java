
public class River extends GameObject{
	
	public River(){
		setSymbol('^'); 
	}
	
	public void addRiver(GameScreen screen, River river, int startingY) {
		for (int i = 1; i < screen.getScreenWidth()-1; i++) {
			screen.setObjectOnLocation(river, i, startingY);
		}
	}
	
}