package eg.edu.alexu.csd.oop.game.view;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.Iterator;
import eg.edu.alexu.csd.oop.game.Strategy;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.controller.Main;
import eg.edu.alexu.csd.oop.game.model.ClownObject;
import eg.edu.alexu.csd.oop.game.model.Dynamic;
import eg.edu.alexu.csd.oop.game.model.FactorySpeed;
import eg.edu.alexu.csd.oop.game.model.FlyWeightLevel;
import eg.edu.alexu.csd.oop.game.model.GameState;
import eg.edu.alexu.csd.oop.game.model.ImageObject;
import eg.edu.alexu.csd.oop.game.model.Lists;
import eg.edu.alexu.csd.oop.game.model.ShapeFactory;
import eg.edu.alexu.csd.oop.game.model.SuperShape;
import eg.edu.alexu.csd.oop.game.model.gameTime;
import eg.edu.alexu.csd.oop.game.model.myScore;
import eg.edu.alexu.csd.oop.game.model.playerShapes;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class Circus implements World {
	
	private static Logger log = Logger.getLogger(Circus.class);
	private List<Class<? extends Strategy>> supported ;
	Dynamic dLinkage ;
    private playerShapes playerShapes;
    private myScore score;
    private gameTime time;
	private final int width;
	private final int height;
	private Lists lists;
	private Iterator iter;
	private SuperShape shape1 = new SuperShape();
	private SuperShape shape2 = new SuperShape();
	private ShapeFactory factory = new ShapeFactory();
	private String level = "";
	GameState state ;
	
	public Circus(int screenWidth, int screenHeight, String level) {
	
		log.info("Start a New Game");
		lists = new Lists();  
	    iter = lists.getIterator();
		score = new myScore();
		playerShapes = new playerShapes(score, iter);
		time = new gameTime(score);
		score.setObserver(playerShapes);
		dLinkage = new Dynamic();
		supported = dLinkage.getSupportedShapes();
		this.level = level;
		this.width = screenWidth;
		this.height = screenHeight;
		this.state = new GameState(this.iter , this.score , this.time);
		
		iter.addConstant(new ImageObject(0, 0, "/bb.png"));
		
		
		for (int i = 0; i < 20; i++) {
			SuperShape shape = (SuperShape)factory.getShape(randomShape(),supported);
			 shape.setColor(randomColor());
			 shape.setX((int) (Math.random() * 1890));
			 shape.setY(-1 * (int) (Math.random() * 945));
			 shape.setVisible(true);
			 iter.addMoving(shape);
			 
		}
		 if (level.toLowerCase().equals("medium")) {
			 iter.addMoving((new FlyWeightLevel((int) (Math.random() * width), -1 * (int) (Math.random() * height)).levelmedium()));
			 iter.addMoving((new FlyWeightLevel((int) (Math.random() * width), -1 * (int) (Math.random() * height)).levelmedium()));

		 }else if (level.toLowerCase().equals("hard")) {
			 iter.addMoving((new FlyWeightLevel((int) (Math.random() * width), -1 * (int) (Math.random() * height)).levelmedium()));
			 iter.addMoving((new FlyWeightLevel((int) (Math.random() * width), -1 * (int) (Math.random() * height)).levelmedium()));
			 iter.addMoving((new FlyWeightLevel((int) (Math.random() * width), -1 * (int) (Math.random() * height)).levelhard()));
			 iter.addMoving((new FlyWeightLevel((int) (Math.random() * width), -1 * (int) (Math.random() * height)).levelhard()));

		 }
		 iter.addControl(ClownObject.getInstance());
		
		 shape1.setColor(randomColor());
		
		 shape1.setX(iter.getControl(0).getX());
		
		 shape1.setY (iter.getControl(0).getY()+5);
		 shape1.setType(1);
		 
		 iter.addControl(shape1);
		 shape2.setColor(randomColor());
		
		 shape2.setX(iter.getControl(0).getX() +259);
		 shape2.setY (iter.getControl(0).getY()+5);
		 shape2.setType(2);
		iter.addControl(shape2);
	}

	public String randomShape() {
		log.info("Choose a random shape");
		int rand = new Random().nextInt(3);
		if (rand == 0) {
			log.info("Create a ball");
			return "BallObject";
		} else if (rand == 1) {
			log.info("Create a square");
			return "SquareObject";
		}
		log.info("Create a triangle");
		return "TriangleObject";
	}

	@Override
	public List<GameObject> getConstantObjects() {
		return iter.getConstant();
	}

	@Override
	public List<GameObject> getMovableObjects() {
		return iter.getMoving();
	}

	@Override
	public List<GameObject> getControlableObjects() {
		return iter.getControl();
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	public Color randomColor() {
		log.info("Choose a random color");
		int rand = new Random().nextInt(3);
		if (rand == 0) {
			log.info("Make the shape color is red");
			return Color.RED;
		} else if (rand == 1) {
			log.info("Make the shape color is blue");
			return Color.BLUE;
		}
		log.info("Make the shape color is green");
		    return Color.GREEN;
	}

	private boolean intersectleft(GameObject o) {
		log.info("Check intersection with shape in left hand");
		return (Math.abs((shape1.getX()+shape1.getWidth()/2) - (o.getX()+o.getWidth()/2)) <= shape1.getWidth()) && (Math.abs((shape1.getY()+shape1.getHeight()/2) - (o.getY()+o.getHeight()/2)) <= shape1.getHeight());

	}
	private boolean intersectright(GameObject o) {
		log.info("Check intersection with shape in right hand");
		return (Math.abs((shape2.getX()+shape2.getWidth()/2) - (o.getX()+o.getWidth()/2)) <= shape2.getWidth()) && (Math.abs((shape2.getY()+shape2.getHeight()/2) - (o.getY()+o.getHeight()/2)) <= shape2.getHeight());

	}

	private boolean intersectClown(GameObject o) {
		return (Math.abs((ClownObject.getInstance().getX()-150+ClownObject.getInstance().getWidth()/2) - (o.getX()+o.getWidth()/2)) <= ClownObject.getInstance().getWidth()) && (Math.abs((ClownObject.getInstance().getY()+100+ClownObject.getInstance().getHeight()/2) - (o.getY()+o.getHeight()/2)) <= ClownObject.getInstance().getHeight()) && !(o.getX() < ClownObject.getInstance().getX());

	}

	@Override
	public boolean refresh() {
		
        boolean bomb = true;
        boolean limit = false;
        log.info("Reuse the shapes and make them falling again");
		for (int i = 0 ;i < iter.getMoving().size();i++) {
			SuperShape m = (SuperShape) iter.getMoving(i);
			((GameObject) m).setY(m.getY() + 1);
			if (m.getY() == getHeight()) {
				m.setY(-1 * (int) (Math.random() * getHeight()));
				m.setX((int) (Math.random() * getWidth()));
			}
			
			m.setX(m.getX() + (Math.random() > 0.5 ? 1 : -1));
			String l2 = m.getClass().getName();
			log.info("Ckeck if the player hits the bomb");
			if((l2.substring(l2.lastIndexOf('.') + 1)).equals("ImageObject")) {
				if(intersectleft(m)||intersectright(m) || intersectClown(m)) {
				log.info("The player hit the bomb");
				log.info("Decrease the player's score");
				bomb = score.decreaseScore();
				m.setX((int)(Math.random() * width));
				m.setY( -1 * (int)(Math.random() * height));
			}
			}else {
			if (intersectleft(m)) {
				
				if (m.isVisible()) {
					
					log.info("The player picks a shape in his left hand");
						String l = m.getClass().getName().toString();
						l=l.substring(l.lastIndexOf('.') + 1);
						SuperShape get = (SuperShape) factory.getShape(l,supported);
						get.setColor(m.getColor());
						get.setX(shape1.getX());
						get.setY(shape1.getY()-60);
						get.setType(1);
						
						iter.addControl(get);
						playerShapes.addShapeLeft(get);
						
						shape1.setType(0);
						shape1.setY(shape1.getY()-60);
						shape1.setType(1);
						log.info("Check if the score will increase or not");
						log.info("Check the color of last 3 shapes");
                   	if(score.updated()) {
                   		log.info("Increase score");
	                    	shape1.setType(0);
	 						shape1.setY(shape1.getY()+180);
	 						shape1.setType(1);
	                     }
	                                  
	                     m.setX((int)(Math.random() * width));
							m.setY( -1 * (int)(Math.random() * height));
					} else if (Math.random() > 0.999) {
						 m.setX((int) (Math.random() * 940));
						 m.setY(-1 * (int) (Math.random() * 540));
						
					
				}
				
				}
			if (intersectright(m)) {
				if (m.isVisible()) {
					
					log.info("The player picks a shape in his right hand");
					String l = m.getClass().getName().toString();
					l=l.substring(l.lastIndexOf('.')+1);
					
					SuperShape get = (SuperShape) factory.getShape(l,supported);
					
					get.setColor(m.getColor());
					get.setX(shape2.getX());
					get.setY(shape2.getY()-60);
					get.setType(2);
					
					iter.addControl(get);
					
					playerShapes.addShapeRight(get);
					shape2.setType(0);
					shape2.setY(shape2.getY()-60);
					shape2.setType(2);

					log.info("Check if the score will increase or not");
					log.info("Check the color of last 3 shapes");
               	if(score.updated()) {
               		log.info("Increase score");
                  	 shape2.setType(0);
					 shape2.setY(shape2.getY()+180);
					 shape2.setType(2); 
                 }            
					m.setX((int)(Math.random() * width));
					m.setY( -1 * (int)(Math.random() * height));
				} else if (Math.random() > 0.999) {
					 m.setX((int) (Math.random() * 940));
					 m.setY(-1 * (int) (Math.random() * 540));
				}
			}
			}
			}
		if (((shape1.getY() <= 0) ? false : true) && ((shape2.getY() <= 0) ? false : true)) {
			limit = true;
		}
		state.setState(bomb, limit);
		return true;
	}

	@Override
	public String getStatus() {
		return state.getResult();

	}

	@Override
	public int getSpeed() {
		return ((new FactorySpeed(level))).getspeed();
	}

	@Override
	public int getControlSpeed() {
		return ((new FactorySpeed(level))).getcontrolspeed();
	}
	

}
