package vagues;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class window extends Canvas {
	
	

	public window(int width,int length,String name, Game g,int frames) {
		JFrame frame = new JFrame(name + frames);
	//	frame.setPreferredSize(new Dimension(width, length));	
		
		//set size 
		frame.setSize(new Dimension(width, length));
		
		
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//adding game into the frame
		frame.add(g);
		
		// set resisable
	
		
		frame.setVisible(true);
		frame.setTitle(name + frames);
		g.start();
	}

	public void add(JFrame frame) {
		// TODO Auto-generated method stub
		
	}
	
}
