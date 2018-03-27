package vagues;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> objList = new LinkedList<GameObject>();
	
	public void update() {
		for(int i =  0; i < objList.size();++i) {
			
			
			GameObject t = objList.get(i);
			t.update();
		}
			
			
			
	}
		
	public void render(Graphics g) {
		for(int i =  0; i < objList.size();++i) {
			
			
			GameObject t = objList.get(i);
			t.render(g);		
			}
	
	}
	
	
	// add the game object to the list
	
	public void addobj(GameObject obj) {
		objList.add(obj);
	}
	
	// to remove the object from list
	public void remove(GameObject obj) {
		objList.remove(obj);
	}
}
