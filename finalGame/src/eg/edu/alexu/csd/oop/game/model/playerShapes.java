package eg.edu.alexu.csd.oop.game.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.Iterator;

public class playerShapes extends Observer {
	private ArrayList<SuperShape> shapesINLeft;
	private ArrayList<SuperShape> shapesINRight;
	private CareTaker careTakerLeft;
	private CareTaker careTakerRight;
	private Originator originatorLeft;
	private Originator originatorRight;
	private List<ObserverScore> observers = new ArrayList<ObserverScore>();
	private String position ;
	private Iterator iter;
	private Color colorLeft;
	private Color colorRight;

	public playerShapes(myScore score,Iterator iter) {
		this.iter = iter;
		colorLeft = new Color(0);
		colorRight = new Color(0);
		shapesINLeft = new ArrayList<SuperShape>();
		shapesINRight = new ArrayList<SuperShape>();
		originatorLeft = new Originator();
		originatorRight = new Originator();
		careTakerLeft = new CareTaker();
		careTakerRight = new CareTaker();
		originatorRight.setState(0);
		originatorLeft.setState(0);
		careTakerRight.add(originatorRight.saveStateToMemento());
		careTakerLeft.add(originatorLeft.saveStateToMemento());
		this.score = score;
		this.score.attach(this);
		position ="";
	}

	public void addShapeLeft(SuperShape shape) {
		shapesINLeft.add(shape);
		if(colorLeft.equals(shape.getColor())) {
		originatorLeft.setState(originatorLeft.getState()+1);
		careTakerLeft.add(originatorLeft.saveStateToMemento());
		} else {
			originatorLeft.setState(1);
			careTakerLeft.add(originatorLeft.saveStateToMemento());
		}
		colorLeft = shape.getColor(); 
		position = "left";
		notifyAllObservers(shape,position);
	}
	public void addShapeRight(SuperShape shape) {
		shapesINRight.add(shape);
		if(colorRight.equals(shape.getColor())) {
		originatorRight.setState(originatorRight.getState()+1);
		careTakerRight.add(originatorRight.saveStateToMemento());
		} else {
			originatorRight.setState(1);
			careTakerRight.add(originatorRight.saveStateToMemento());
		}
		colorRight = shape.getColor();
		position = "right";
		notifyAllObservers(shape,position);
	}

	@Override
	public void update() {
		if(position.equals("left")) {
			removelast3ShapesLeft();
		}
		else if(position.equals("right")){
			removelast3ShapesRight();
		}

	}

	private void removelast3ShapesLeft() {
		for (int i = 0; i < 3; i++) {
			iter.removeControl(shapesINLeft.get(shapesINLeft.size()-1));
			shapesINLeft.remove(shapesINLeft.size()-1);
		}
		if(shapesINLeft.size() != 0) {
			colorLeft = shapesINLeft.get(shapesINLeft.size()-1).getColor();
			} else {
				colorLeft = new Color(0);
			}
		originatorLeft.getStateFromMemento(careTakerLeft.get());
	}
	private void removelast3ShapesRight() {
		for (int i = 0; i < 3; i++) {
			iter.removeControl(shapesINRight.get(shapesINRight.size()-1));
			shapesINRight.remove(shapesINRight.size()-1);
		}
		if(shapesINRight.size() != 0) {
		colorRight = shapesINRight.get(shapesINRight.size()-1).getColor();
		} else {
			colorRight = new Color(0);
		}
		originatorRight.getStateFromMemento(careTakerRight.get());
	}
	public void attach(ObserverScore observer){
	      observers.add(observer);		
	   }

	   public void notifyAllObservers(SuperShape shape, String position){
	      for (ObserverScore observer : observers) {
	    	  if(position.equals("left")) {
	         observer.update(originatorLeft.getState());
	    	  }
	    	  if(position.equals("right")) {
	 	         observer.update(originatorRight.getState());
	 	    	  }
	      }
	   } 	
}
