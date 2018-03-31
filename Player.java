package vagues;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	public Player(int x, int y, ID id) {
		super(x, y, id);
	
		}


	public void update() {
		x += 0;
		y += 0;
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
	g.fillRect(x, y, 32, 32);
	
		
	}
	
	

	
}
