package eg.edu.alexu.csd.oop.game.model;

public class Originator {
	  private  int state;
	  Originator(){
		  state = 0;
	  }
	   public void setState(int state){
	      this.state = state;
	   }

	   public int getState(){
	      return state;
	   }

	   public Memento saveStateToMemento(){
	      return new Memento(state);
	   }

	   public  void getStateFromMemento(Memento memento){
	      state = memento.getState();
	   }
}
