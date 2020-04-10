package eg.edu.alexu.csd.oop.game.model;

import eg.edu.alexu.csd.oop.game.State;

public class Continue implements State{
	
	private GameState state;
	
	public Continue (GameState state) {
		this.state = state;
	}
	
	

	@Override
	public String getResult() {
		String status = "Score=" + state.score.getScore() + "   |   Time=" + state.time.getCurrentTime();
		return status;
		
	}



}
