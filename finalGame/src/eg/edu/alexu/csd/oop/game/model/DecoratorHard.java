package eg.edu.alexu.csd.oop.game.model;

import eg.edu.alexu.csd.oop.game.StrategyLevels;

public class DecoratorHard implements StrategyLevels{

	@Override
	public int Speed() {
		return 1;
	}

	@Override
	public int SpeedControl() {
		// TODO Auto-generated method stub
		return 50;
	}

}
