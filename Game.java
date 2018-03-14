package Main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable
// or extends thread 
{

	
	public static final int width = 640,length = width / 12*9 ;
	
	// create a thread 
	private Thread thread;
	private boolean running = true;
	
	
		
	
	public Game() {
		window win = new window(width, length, " *^* Console *^* ", this);

	}
	
	
	
	public synchronized void start() {
		
		thread = new Thread(this);
	thread.start();
	running = true;
	}
	
	
public synchronized void stop() {
		
	try {
		thread = new Thread(this);
	thread.start();
	running = false;
	}catch(Exception e) {
		System.out.print(e.);
	}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
	Game firstGame = new Game();
	
	
	}

	
	
	

}
