package vagues;

import java.awt.BufferCapabilities;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;



public class Game extends Canvas implements Runnable
// or extends thread 
{

	
	public static final int width = 640,height  = width / 12*9 ;
	
	// create a thread 
	private Thread thread;
	private boolean running = true;
	private Random random;
	
	Handler handles;
		
	
	public Game() {
		window win = new window(width, height, " *^* Console *^* ", this);
		handles = new Handler();
		random = new Random();
		for( int i = 1; i < 50;++i) {
		handles.addobj(new Player(random.nextInt(width), random.nextInt(height), ID.Player));
		}

	}
	
	
	// start method and start a new thread 
	public synchronized void start() {
		
		thread = new Thread(this);
	thread.start();
	running = true;
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
/*	
public void run() {
	  long lastTime = System.nanoTime(); // get current time to the nanosecond
	  double amountOfTicks = 60.0; // set the number of ticks 
	  double ns = 1000000000 / amountOfTicks; // this determines how many times we can devide 60 into 1e9 of nano seconds or about 1 second
	  double delta = 0; // change in time (delta always means a change like delta v is change in velocity)
	  long timer = System.currentTimeMillis(); // get current time
	  int frames = 0; // set frame variable
	  while(running){ 
	   long now = System.nanoTime(); // get current time in nonoseconds durring current loop
	   delta += (now - lastTime) / ns; // add the amount of change since the last loop
	   lastTime = now;  // set lastTime to now to prepare for next loop
	   while(delta >= 1){
	    // one tick of time has passed in the game this 
	    //ensures that we have a steady pause in our game loop 
	    //so we don't have a game that runs way too fast 
	    //basically we are waiting for  enough time to pass so we 
	    // have about 60 frames per one second interval determined to the nanosecond (accuracy)
	    // once this pause is done we render the next frame
	    tick();  
	    delta--;  // lower our delta back to 0 to start our next frame wait
	   }
	   if(running){
	    render(); // render the visuals of the game
	   }
	   frames++; // note that a frame has passed
	   if(System.currentTimeMillis() - timer > 1000 ){ // if one second has passed
	    timer+= 1000; // add a thousand to our timer for next time
	    System.out.println("FPS: " + frames); // print out how many frames have happend in the last second
	    frames = 0; // reset the frame count for the next second
	   }
	  }
	  stop(); // no longer running stop the thread
	 }
	*/

	
	@Override
	public void run() {
	
		// reterive system's time in nano second 
		long lastTime = System.nanoTime();// time in nano sec
		// how many we want our update method to run 
		double ammountOfTicks  = 60.0; //number of ticks
		double ns = 1000000000 / ammountOfTicks ; 
		double delta = 0 ; // change in time 
		long timer = System.currentTimeMillis();// time in milli sec
	int frames = 0 ; // set frame variable 
		
		
		while(running ) {
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
			    System.out.println("FPS: " + frames); // print out how many frames have happend in the last second
			    frames = 0; // reset the frame count for the next second
			   }
		}
		//stop(); // no longer running stop the thread
		
	}
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
