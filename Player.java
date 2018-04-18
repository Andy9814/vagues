package vagues;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{


	public Player(int x, int y, ID id) {
		super(x, y, id);
	
		}


	public void update() {
		x += velX;
		y += velY;
		
	}

	
	public void render(Graphics g) {
		if(id == id.Player) {g.setColor(Color.GREEN);}
		else if(id== id.player2) { g.setColor(Color.RED);}
	g.fillRect(x, y, 32, 32);
	
		
	}
	
	

	
}
