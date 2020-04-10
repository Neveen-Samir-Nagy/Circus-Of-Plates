package eg.edu.alexu.csd.oop.game;

import java.util.List;

public interface Iterator {
	public void addConstant(GameObject object);
	public void addControl(GameObject object);
	public void addMoving(GameObject object);
	public void removeConstant(GameObject object);
	public void removeControl(GameObject object);
	public void removeMoving(GameObject object);
	public List<GameObject> getConstant();	
	public List<GameObject> getControl();	
	public List<GameObject> getMoving();
	public GameObject getControl(int index);
	public GameObject getMoving(int index);
}
