package eg.edu.alexu.csd.oop.game.model;

import eg.edu.alexu.csd.oop.game.State;

public class Context {
	   private State state;
	   private int time;
	   private int score;

	   public Context(int time , int score){
	      state = null;
	      this.time = time;
	      this.score = score;
	   }

	   public void setState(State state){
	      this.state = state;		
	   }

	   public State getState(){
	      return state;
	   }
	}
