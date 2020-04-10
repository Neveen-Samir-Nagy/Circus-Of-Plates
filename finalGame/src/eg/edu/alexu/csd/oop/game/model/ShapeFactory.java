package eg.edu.alexu.csd.oop.game.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.Strategy;



public class ShapeFactory {
	private List<Class<? extends Strategy>> shapes;

	public ShapeFactory() {
		// TODO Auto-generated constructor stub

	}
	   public Strategy getShape(String shapeType,List<Class<? extends Strategy>> newShapes){
		   
			this.shapes = newShapes;
			

			Strategy shape = null;
			for (Class<? extends Strategy> shapeClass : shapes) {
				
				if (shapeType.equals(shapeClass.getName().substring(30, shapeClass.getName().length()))) {
					//System.out.println(shapeType);
					//
					try {
						shape = (Strategy) shapeClass.newInstance();
						//System.out.println(shape);
						
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			return shape;
		}
	   
		
	  
	   
	   	   public GameObject getShape(GameObject shape, List<Class<? extends Strategy>> newShapes){
	   		   	  String shapeType = shape.getClass().getName().toString();
	   		   shapes = newShapes;

				GameObject myShape = null;
				for (Class<? extends Strategy> shapeClass : shapes) {

					if (shapeType.substring(shapeType.lastIndexOf('.')+1).equals(shapeClass.getName().substring(30, shapeClass.getName().length()))) {

						try {
							myShape = (GameObject) shapeClass.newInstance();
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
				return (GameObject) myShape;
			}
	   		
	   	   
}
