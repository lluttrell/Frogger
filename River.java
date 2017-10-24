public class River extends GameObject{

	public River(int y) {
		setSymbol('^');
    setLength(super.getScreenWidth()-1);
    setX(super.getScreenWidth()/2-1);
    setY(y);
	}
}
