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
	
	
	// getter and setter methods for x and y
	
	
	public int  getx() {
	
		
		
		return x;
				
				
	}
	
public  void   setx( int x) {
	this.x = x;
		
		
		
				
	}

public int  gety() {
	
	
	
	return y;
			
			
}

public void sety(int y) {
	this.y = y;
	

			
}
      

public int  getVelx() {

	
	
	return velX;
			
			
}

public  void   setVelx( int x) {
this.velX = x;
	
	
	
			
}

public int  getVelY() {



return velY;
		
		
}

public void setVely(int y) {
this.velY = y;


		
}


public ID  getID (){
	
	return id;
			
}

public void setID (ID id){
	
	this.id = id;
}


	 
}
