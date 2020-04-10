package eg.edu.alexu.csd.oop.game.model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.controller.Main;

public class ClownObject implements GameObject{
	
	private static Logger log = Logger.getLogger(ClownObject.class);
	
	private static final int MAX_MSTATE = 1;
	// an array of sprite images that are drawn sequentially
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int x = (int) (1900/2.5) ;
	private int y = (int) (955*0.8);
	private String path = "/cl.png";
	private boolean visible;
	private int type;
	
	
	
	private ClownObject(){
		this.visible = true;
		// create a bunch of buffered images and place into an array, to be displayed sequentially
		try {
			spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    private static ClownObject oneObject;
	
	
	
	public static synchronized ClownObject getInstance(){
		log.info("Check if there is a player or not ");
	if (oneObject == null){
		log.info("There is no player yet");
		log.info("Creat a new player");
		oneObject = new ClownObject();
	}
	return oneObject;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
		
	}

	@Override
	public int getY() {
		
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
		return spriteImages[0].getWidth();
	}

	@Override
	public int getHeight() {
		return spriteImages[0].getHeight();
	}

	@Override
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}

}
