package vagues;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	public Player(int x, int y, ID id) {
		super(x, y, id);
		velX = r.nextInt(5);
		
		velY = r.nextInt(5);
		}


	public void update() {
		x = x +velX;
		y = y + velY;
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
	g.fillRect(x, y, 32, 32);
	
		
	}
	
	

	
}
