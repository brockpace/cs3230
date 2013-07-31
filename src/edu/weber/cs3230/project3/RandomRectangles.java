package edu.weber.cs3230.project3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RandomRectangles {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				RectangleFrame frame = new RectangleFrame();
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
	private JSlider slider;
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 500;
	private int numRectangles;
	
	public RectangleFrame() {		
		setTitle("Random Rectangle Viewer");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		moreButton = new JButton("More");
		fewerButton = new JButton("Fewer");
		numRectangles = 100;		
		
		buttonPanel = new JPanel();
		mainPanel = new MainPanel();
		//Part A
//		buttonPanel.add(moreButton);
//		buttonPanel.add(fewerButton);
		
		//Part B
		slider = new JSlider(0, 512);
		buttonPanel.add(slider);
		
		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		//Part A
//		moreButton.addActionListener(new RectangleAction());
//		fewerButton.addActionListener(new RectangleAction());
		
		//Part B
		slider.addChangeListener(new RectangleAction());
	}
	
	//Part A
//	private class RectangleAction implements ActionListener {
//		//this is called when the actionlistener is notified that what it is listening for happened. it than calls the action Performed
//		public void actionPerformed(ActionEvent event){
//			//System.out.println(numRectangles);
//			if (event.getSource() == moreButton) {
//				numRectangles *= 2;
//				repaint();
//			} else if (event.getSource() == fewerButton) {
//				numRectangles /= 2;
//				if(numRectangles < 1)
//					numRectangles = 1;
//				repaint();
//			}
//		}
//	}
	
	//Part B
	private class RectangleAction implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent arg0) {
			numRectangles = slider.getValue();
			repaint();
		}
	}
	
	//Inner Class MainPanel that extends JPanel
	class MainPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			Random r = new Random();
			
			for(int i = 0; i < numRectangles; i++) {
				int y = r.nextInt(this.getWidth()) + 1;
				int x = r.nextInt(this.getHeight()) + 1;
				Rectangle2D rect = new Rectangle2D.Double(x, y, 50, 25);
				g2.draw(rect);
			}
		}
	}
}

