package eg.edu.alexu.csd.oop.game.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import eg.edu.alexu.csd.oop.game.Iterator;
import eg.edu.alexu.csd.oop.game.State;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class GameState {
	private static int MAX_TIME = 1 * 60 * 1000;
	State win;
	State Con;
	State gameOver;
	State gameState;
	Iterator iter;
	myScore score;
    gameTime time;
    boolean flag = false;
    private boolean won = false;
	
	public GameState(Iterator iter , myScore score , gameTime time ) {
		
		this.win = new Win(this);
		this.gameOver = new GameOver(this);
		this.Con = new Continue(this);
		if(flag) {
			this.gameState = gameOver;
		}else {
		this.gameState = Con;
		}
		this.iter = iter;
		this.score = score;
		this.time = time;
		
		}
	
	
	public void setState (boolean bomb , boolean limit) {
			 if ((time.timeout() && score.getScore() != 7) 
				|| (score.getScore() == 0 && !bomb) || !limit ) {
			this.gameState = gameOver;
			try {
				FileInputStream fileInputStream = new FileInputStream("gameOver.mp3");
				Player player = new Player(fileInputStream);
				
				player.play();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = true;
			
		}
			else if (score.getScore() == 7 && time.getCurrentTime() < MAX_TIME && !won) {
				won = true;
			this.gameState = win;
			try {
				FileInputStream fileInputStream = new FileInputStream("win.mp3");
				Player player = new Player(fileInputStream);
				
				player.play();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (!flag) {
			this.gameState = Con;
			
			
		}
	}
	
	public String getResult() {
		return gameState.getResult();
	}


}
