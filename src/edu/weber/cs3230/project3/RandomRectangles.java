package edu.weber.cs3230.project3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
	
   private JPanel buttonPanel;
   private JPanel mainPanel;
   private JButton moreButton;
   private JButton fewerButton; 
   public static final int DEFAULT_WIDTH = 500;
   public static final int DEFAULT_HEIGHT = 700;
   private int numRectangles;
	
	public RectangleFrame() {
		setTitle("Random Rectangle Viewer");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		moreButton = new JButton("More");
		fewerButton = new JButton("Fewer");
		numRectangles = 100;
		
		buttonPanel = new JPanel();
		mainPanel = new JPanel();
		
		buttonPanel.add(moreButton);
		buttonPanel.add(fewerButton);
		
		add(mainPanel);
		add(buttonPanel, BorderLayout.SOUTH);
		
		
		
		moreButton.addActionListener(new RectangleAction());
		fewerButton.addActionListener(new RectangleAction());
		
		
	}
	   private class RectangleAction implements ActionListener
	   {
	      //this is called when the actionlistener is notified that what it is listening for happened. it than calls the action Performed
	      public void actionPerformed(ActionEvent event)
	      {
	         //mainPanel.setBackground(Color.GREEN);
	            	  
	    	  
	         if (event.getSource() == moreButton) {
	        	 numRectangles *= 2;
	        	 //paintComponent(this.getGraphics());
	         } else if (event.getSource() == fewerButton) {
	        	 numRectangles /= 2;
	         }
	      }
	      
		  public void paintComponent(Graphics g)
		   {
		      Graphics2D g2 = (Graphics2D) g;
		      Random r = new Random();
		      int y = r.nextInt(DEFAULT_WIDTH) + 1;
		      int x = r.nextInt(DEFAULT_HEIGHT) + 1;
		      
		   }	
	   }
	
}





