package eg.edu.alexu.csd.oop.game.model;

import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.Container;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.Iterator;

public class Lists implements Container{

	private final List<GameObject> constant ;
	private final List<GameObject> moving ;
	private final List<GameObject> control ;
	
	public Lists() {
	    constant = new LinkedList<GameObject>();
		moving = new LinkedList<GameObject>();
		control = new LinkedList<GameObject>();
	}
	private class Arr implements Iterator {
		@Override
		public GameObject getMoving(int index) {
			return moving.get(index);
		}
	@Override	
	public GameObject getControl(int index) {
		return control.get(index);
		
	}
		
	@Override	
	public void addConstant(GameObject object) {
		constant.add(object);
	}
	@Override
	public void addMoving(GameObject object) {
		moving.add(object);
	}
	@Override
	public void addControl(GameObject object) {
		control.add(object);
	}
	@Override
	public void removeConstant(GameObject object) {
		
		constant.remove(object);
		
	}
	@Override
	public void removeControl(GameObject object) {
		
		control.remove(object);
}
	@Override
	public void removeMoving(GameObject object) {
		
		moving.remove(object);

		
	}
	@Override
	public List<GameObject> getConstant() {
		
		return constant;
	}
	@Override
	public List<GameObject> getControl() {
		
		return control;
	}
	@Override
	public List<GameObject> getMoving() {
		
		return moving;
	}
	}

	@Override
	public Iterator getIterator() {
		
		return new Arr();
	}
	
	
}
