package vagues;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class window extends Canvas {

	public window(int width,int length,String name, Game g) {
		JFrame frame = new JFrame(name);
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
		
		g.start();
	}
	
}
