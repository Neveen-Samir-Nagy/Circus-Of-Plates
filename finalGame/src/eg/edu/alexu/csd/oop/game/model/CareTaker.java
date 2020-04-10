package eg.edu.alexu.csd.oop.game.model;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	 private List<Memento> mementoList = new ArrayList<Memento>();

	   public void add(Memento state){
	      mementoList.add(state);
	      System.out.println(state.getState());
	   }

	   public Memento get(){
		   for (int i = 0; i < 3; i++) {
			   mementoList.remove(mementoList.size()-1);
			}
	      return mementoList.get(mementoList.size()-1);
	   }
}
