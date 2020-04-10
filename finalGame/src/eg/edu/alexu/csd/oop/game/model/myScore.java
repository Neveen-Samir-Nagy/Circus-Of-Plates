package eg.edu.alexu.csd.oop.game.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.Strategy;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class myScore extends ObserverScore {

	private int score;
	private List<Observer> observers = new ArrayList<Observer>();
	private playerShapes shapes;
	private Boolean updated = false;

	public myScore() {
		score = 0;
	}

	public void setObserver(playerShapes shapes) {
		this.shapes = shapes;
		this.shapes.attach(this);
	}

	public void setScore(int newScore) {
		this.score = newScore;
		
		notifyAllObservers();
	}

	public int getScore() {
		return this.score;
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	@Override
	public void update(int state) {
		// check if the score will increase or not
		 updated = false;
			if(state == 3) {
				score++;
				updated = true;
				setScore(score);
				
			}
		
		}
		public boolean decreaseScore() {
			if(score == 0) {
				return false;
			}
			score--;
            return true;
		}
	
	public boolean updated() {
		return updated;

	}	

 }


