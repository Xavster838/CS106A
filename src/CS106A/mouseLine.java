package CS106A;

import acm.graphics.*;	 //package for getting graphics objects
import acm.program.*;	 //package for getting GraphicsProgram
import java.awt.event.*; //package for getting listeners
import java.awt.Dimension;

/**
 * Assignment 3 of Stanford CS106a
 * mouseLine
 * Description:
 * 	a class that allows the user to interact with the program canvas to add lines of his choosing
 * 	class program
 * @author XaviGuitart
 * To Augment: Change canvas size to be bigger
 */
public class mouseLine extends GraphicsProgram {
	
	public void run(){
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e){
		startPointX = e.getX();
		startPointY = e.getY();
		//need to change end points otherwise new line links to last line temporarily
		endPointX = startPointX;
		endPointY = startPointY;
		//make line: initially will just be point
		curLine = new GLine(startPointX , startPointY , endPointX , endPointY);
		add(curLine);
	}
	
	public void mouseDragged( MouseEvent e ){
		endPointX = e.getX();
		endPointY = e.getY();
		curLine.setEndPoint(endPointX , endPointY);
	}

	
	//define instance variables
	private int startPointX;
	private int startPointY;
	private int endPointX;
	private int endPointY;
	private GLine curLine;
}
