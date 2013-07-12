package edu.weber.cs3230.project3;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class RandomRectangles {

	   public static void main(String[] args)
	   {
	      EventQueue.invokeLater(new Runnable()
	         {
	            public void run()
	            {
	            	RectangleFrame  frame = new RectangleFrame();
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
	            }
	         });
	   }
}

class RectangleFrame extends JFrame {
	
	
	
}
