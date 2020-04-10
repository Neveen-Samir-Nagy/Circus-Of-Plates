package eg.edu.alexu.csd.oop.game.model;

public class FactorySpeed {

	private String level = "";
	private Object object;
	public FactorySpeed(String level) {
		this.level = level;
	}
	public int getspeed() {
		 if(level.toLowerCase().equals("medium")) {
			 object = new DecoratorMedium();
			return ((DecoratorMedium)object).Speed();
		}else if(level.toLowerCase().equals("hard")) {
			object = new DecoratorHard();
			return ((DecoratorHard)object).Speed();
		}else {
			object = new DecoratorEasy();
			return ((DecoratorEasy)object).Speed();
		}
	}
	public int getcontrolspeed() {
		 if(level.toLowerCase().equals("medium")) {
			 object = new DecoratorMedium();
			return ((DecoratorMedium)object).SpeedControl();
		}else if(level.toLowerCase().equals("hard")) {
			object = new DecoratorHard();
			return ((DecoratorHard)object).SpeedControl();
		}else {
			object = new DecoratorEasy();
			return ((DecoratorEasy)object).SpeedControl();
		}
	}
}
