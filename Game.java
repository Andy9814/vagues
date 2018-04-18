package vagues;

import java.awt.BufferCapabilities;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.InputMap;
import javax.swing.JFrame;





public class Game extends Canvas implements Runnable
// or extends thread 
{
	int frames = 0; // set frame variable 
	
	public static final int width = 640,height  = width / 12*9 ;
	
	// create a thread 
	private Thread thread;
	private boolean running = false;
	private Random random;
	
private	handler handles;
private window win;
	

	public Game() {
		// we need to put it above window
		handles = new handler();
		
		random = new Random();
		 win =	 new window(width, height, " *^* Console *^*   ", this,frames);
			
		handles.addobj(new Player(300, 150, ID.Player));
		
		handles.addobj(new Player(400, 150, ID.player2));
		this.addKeyListener(new KeyInput(handles));

	}
	// start method and start a new thread 
	public synchronized void start() {
		
		thread = new Thread(this);
		running = true;
		
	thread.start();

	}

	
	public void run()
	{
		
		
		// reterive system's time in nano second 
		long lastTime = System.nanoTime();// time in nano sec
		// how many we want our update method to run 
		double ammountOfTicks  = 60.0; //number of ticks
		double ns = 1000000000 / ammountOfTicks ; 
		double delta = 0 ; // change in time 
		long timer = System.currentTimeMillis();// time in milli sec
	
		
		
		while(running ) 
		{
			// again get sytem's time in nano sec. we are getting it again coz system takes time to run run this loop
			long now= System.nanoTime();// current time
			delta += (now - lastTime)/ns;
			lastTime= now; 
			while(delta >= 1) {
				  update();  // update 
				    delta--;  // lower our delta back to 0 to start our next frame wait
			}
			

			if(running){
			    render(); // render the visuals of the game
			   }
			frames++; // note that a frame has passed
			   if(System.currentTimeMillis() - timer > 1000 ){ // if one second has passed
			    timer+= 1000; // add a thousand to our timer for next time
			   
			  //  System.out.println("FPS: " + frames); // print out how many frames have happend in the last second
			   frames = 0; // reset the frame count for the next second
			   }
		}
		
	
		//stop(); // no longer running stop the thread
		
	}


	// stop method // running = false

	
	/*
	
	// stop method and start a new thread
public synchronized void stop() {
		
	try {
		thread = new Thread(this);
	thread.start();
	running = false;
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	*/


	
	
	//Tick or update method it is logic method
	private void update() {
		handles.update();
		
	}
	
	/*
	 * 
	 * GRAPHICALL METHODS 
	 * 
	 * 
	 */
	private void render()
	{
//		Graphics panGraphics = this.getGraphics();
//		BufferedImage buffImage= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		
		
		
		
		
		
		BufferStrategy buff= this.getBufferStrategy();
		if(buff == null) {
		 this.createBufferStrategy(3);
		 return ;
		}
		
		Graphics g = buff.getDrawGraphics();
		// Now here is the trick this set color and rect fill is for window fill and color in window 
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// this handles fill color in player, getting graphics from buffer and getting inputs from player object 
		handles.render(g);
	
		// we have to use each graphic to show before we dispose it, mean destroy it.
		g.dispose();
		buff.show();
		
		
	}

	public static void main(String[] args) {
		
	Game firstGame = new Game();
	
	

	
	}





	
	
	

}
