package eg.edu.alexu.csd.oop.game.model;

public class gameTime extends Observer{
	private static int MAX_TIME = 1 * 60 * 1000;
	private long startTime;
	
	public gameTime(myScore score) {
		startTime = System.currentTimeMillis();
		this.score = score;
		this.score.attach(this);
	}
	
	public int getCurrentTime() {
		return (int) Math.max(0, (MAX_TIME - (System.currentTimeMillis()-startTime))/1000);
	}
	
	public boolean timeout() {
		return System.currentTimeMillis() - startTime > MAX_TIME;
	}

	@Override
	public void update() {
		this.increaseTime();
		}
	
	private void increaseTime() {
		startTime = startTime +5000;
	}
}
