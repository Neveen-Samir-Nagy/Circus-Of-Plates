package eg.edu.alexu.csd.oop.game.model;

public class FlyWeightLevel {

	private ImageObject imagemedium = null;
	private ImageObject imagehard = null;
	private int x;
	private int y;
	public FlyWeightLevel(int posx, int posy) {
		this.x = posx;
		this.y = posy;
	}
	public ImageObject levelmedium() {
		if(imagemedium==(null)) {
			imagemedium = new ImageObject(x, y, "/bomb.png");
			System.out.println(imagemedium);

		}
		return imagemedium;
	}
	public ImageObject levelhard() {
		if(imagehard==(null)) {
			imagehard = new ImageObject(x, y, "/skull.png");
		}
		return imagehard;
	}
	
}
