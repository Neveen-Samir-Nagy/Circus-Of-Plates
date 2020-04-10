package eg.edu.alexu.csd.oop.game.model;

public class Memento {
	   private int state;
	   Memento(){
		   state = 0;
	   }
	   public Memento(int state){
	      this.state = state;
	   }

	   public int getState(){
	      return state;
	   }
}
