package edu.weber.cs3230.project3;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	public RectangleFrame() {
		setSize(300,400);
		JButton moreButton = new JButton("More");
		JButton fewerButton = new JButton("Fewer");
		
		buttonPanel = new JPanel();
		mainPanel = new JPanel();
		
	}
	public void paintComponent(Graphics g)
	   {
	      Graphics2D g2 = (Graphics2D) g;
	
	   
	   }
	
	   private JPanel buttonPanel;
	   private JPanel mainPanel;
	   public static final int DEFAULT_WIDTH = 400;
	   public static final int DEFAULT_HEIGHT = 500;
	   public static final int DEFAULT_HIEGHT_BUTTONPANEL2 = 100;
	
}
