package eg.edu.alexu.csd.oop.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.Strategy;

public class SuperShape implements GameObject,Strategy{
	private static final int SPRITE_WIDTH =60;
	private static final int MAX_MSTATE = 1;
	private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
	private int x = (int)(Math.random() * 1900);
	private int y = -1 * (int)(Math.random() * 955);
	private int type = 0;
	private Boolean visible;
	private Color color;
	
	public SuperShape(){
		this.visible = true;
		spriteImages[0] = new BufferedImage(SPRITE_WIDTH, SPRITE_WIDTH,	BufferedImage.TYPE_INT_ARGB);	
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		if(type == 1 && x > 1601 || type == 2 && x > 1860 || type == 1 && x < 0 ||type == 2 && x < 240 ) {
		} else {
			this.x = x;
		}
	}

	@Override
	public int getY() {
		Graphics2D g2 = spriteImages[0].createGraphics();
		draw(g2);	
		return y;
	}

	@Override
	public void setY(int y) {
		if(type == 0) {
		this.y = y;
		}
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		return spriteImages;
	}

	@Override
	public int getWidth(){
		return SPRITE_WIDTH;
	}

	@Override
	public int getHeight() {
		return SPRITE_WIDTH;
	}
	
	@Override
	public void setColor(Color color) {
		this.color = color;
	}	
	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void draw(Graphics canvas) {
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible=visible;
	}


	@Override
	public boolean isVisible() {
		return visible;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
