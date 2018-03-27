package vagues;

import java.awt.Graphics;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected int velX,velY;
	
	// when we make player Game object we set these parameters for that game object i.e player or enemy
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		
	}
	 
	 
	public abstract void update();
	public abstract void render(Graphics g);
	 
}
