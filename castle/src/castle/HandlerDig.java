package castle;

public class HandlerDig extends Handler {

	public HandlerDig(Game game) {
		super(game);
	}

	@Override
	public void doCmd(String word) {
		game.digForTreasure();
	}
	
}
