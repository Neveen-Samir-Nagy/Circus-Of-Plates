package eg.edu.alexu.csd.oop.game.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import eg.edu.alexu.csd.oop.game.State;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class GameOver implements State {
	
	private GameState state;
	
	public GameOver (GameState state) {
		this.state = state;
	}

	@Override
	public String getResult() {
		state.iter.addConstant(new ImageObject(1900/3, 955/3, "/over.png"));
		state.iter.getMoving().clear();
		state.iter.addConstant(ClownObject.getInstance());
		state.iter.getControl().clear();
		String status = "Game Over";
		
		return status;
		
	}
	
	

	
}
