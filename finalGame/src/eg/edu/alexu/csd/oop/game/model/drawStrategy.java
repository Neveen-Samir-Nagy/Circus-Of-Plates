package eg.edu.alexu.csd.oop.game.model;

import java.awt.Graphics;

import eg.edu.alexu.csd.oop.game.Strategy;


public class drawStrategy {
	private Strategy strategy; 
	public drawStrategy(Strategy strategy){
		this.strategy = strategy;
	}
    public void handleDraw(Graphics canvas) {
	  // this.strategy.draw(canvas);
    }
}
