package vagues;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Handler;

public class KeyInput extends KeyAdapter{

	private handler handlet;
	
	public KeyInput(handler handler) {
		this.handlet = handler;
		
	}
	
	public void keyPressed (KeyEvent e) {
		 
		int key = e.getKeyCode();
		
		for(int i = 0; i < handlet.objList.size();++i ) {
			
			GameObject p = handlet.objList.get(i);
			
			if(p.getID()== ID.Player) 
			{	if(key== KeyEvent.VK_W)p.sety(p.gety() -  5 );
			if(key== KeyEvent.VK_S)p.sety(p.gety() + 5 );
			if(key== KeyEvent.VK_D)p.setx(p.getx() + 5 );
			if(key== KeyEvent.VK_A)p.setx(p.getx() -  5 );
			
			}
			if(p.getID() == ID.player2) 
			{
				if(key== KeyEvent.VK_UP) p.sety(p.gety() - 5);	
				if(key== KeyEvent.VK_DOWN) p.sety(p.gety() + 5);
				if(key== KeyEvent.VK_LEFT) p.setx(p.getx() - 5);
				if(key== KeyEvent.VK_RIGHT) p.setx(p.getx() + 5);
				
			}
			
			
		}
		
	}
	
	public void keyReleased (KeyEvent e) {
int key = e.getKeyCode();
		
		for(int i = 0; i < handlet.objList.size();++i ) {
			
			GameObject p = handlet.objList.get(i);
			
			if(p.getID()== ID.Player) 
			{	
				if(key== KeyEvent.VK_W)p.setVely(0);
			    if(key== KeyEvent.VK_S)p.setVely(0);
			    if(key== KeyEvent.VK_D)p.setVelx(0);
			    if(key== KeyEvent.VK_A)p.setVelx(0);
			}
			if(p.getID() == ID.player2) 
			{
				if(key== KeyEvent.VK_UP) p.setVely(0);
				if(key== KeyEvent.VK_DOWN) p.setVely(0);
				if(key== KeyEvent.VK_LEFT) p.setVelx(0);
				if(key== KeyEvent.VK_RIGHT) p.setVelx(0);
				
			}
			
			
		}
	}
}
