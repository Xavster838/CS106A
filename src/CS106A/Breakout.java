	package CS106A;
	/**
	 * Breakout.java
	 * Assignment 3 of Stanford CS106a
	 * This file will implement the game of Breakout
	 * @author XaviGuitart
	 *
	 */
	/*
	 * File: Breakout.java
	 * -------------------
	 * This file will eventually implement the game of Breakout.
	 */
	import acm.graphics.*;
	import acm.program.*;
	import acm.util.*;
	import java.applet.*;
	import java.awt.*;
	import java.awt.event.*;

import javax.crypto.KeyAgreement;
	
	
	public class Breakout extends GraphicsProgram {
		
	/** Width and height of application window in pixels */
	 public static final int APPLICATION_WIDTH = 400;
	 public static final int APPLICATION_HEIGHT = 600;
	 
	/** Dimensions of game board (usually the same) */
	 private static final int WIDTH = APPLICATION_WIDTH;
	 private static final int HEIGHT = APPLICATION_HEIGHT;
	 
	/** Dimensions of the paddle */
	 private static final int PADDLE_WIDTH = 60;
	 private static final int PADDLE_HEIGHT = 10;
	 
	/** Offset of the paddle up from the bottom */
	 private static final int PADDLE_Y_OFFSET = 30;
	 
	/** Number of bricks per row */
	 private static final int NBRICKS_PER_ROW = 10;
	 
	/** Number of rows of bricks */
	 private static final int NBRICK_ROWS = 10;
	 
	/** Separation between bricks */
	 private static final int BRICK_SEP = 4;
	 
	/** Width of a brick */
	 private static final int BRICK_WIDTH =
	 (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
	 
	/** Height of a brick */
	 private static final int BRICK_HEIGHT = 8;
	 
	/** Radius of the ball in pixels */
	 private static final int BALL_RADIUS = 10;
	 
	/** Offset of the top brick row from the top */
	 private static final int BRICK_Y_OFFSET = 70;
	 
	/** Number of turns */
	 private static final int NTURNS = 3;
	 
	 /**Number of Colors.*/ 
	 private static final int NCOLORS = 5;
	 
	 /**Number of rows per color */
	 private static final int N_ROWS_PER_COLOR = NBRICK_ROWS / NCOLORS;
	 
	 public void run() {
		 /* You fill this in, along with any subsidiary methods */
		 setupGame();
		 
		 //addKeyListeners();
		 //addMouseListeners();
	 } 
 	
	 
	 private void setupGame(){
		 //setBounds
		 resize( new Dimension(APPLICATION_WIDTH, APPLICATION_HEIGHT));
		 setBounds();
		 setBricks();
	 }
	 /**
	  * setBounds()
	  * method encapsulating setting of walls of the game
	  */
	 private void setBounds(){
		 GRect bounds = new GRect(WIDTH, HEIGHT);
		 bounds.setColor(Color.GRAY);
		 bounds.setFillColor(Color.GRAY);
		 add(bounds);
	 }
	 
	 /**
	  * setBricks
	  * set the rainbow brick wall of the game
	  */
	 private void setBricks(){
		 
		 for( int row = 0 ; row < NBRICK_ROWS ; row++){
			 setBrickRow(row);
		 }
	 }
	 /**
	  * setBrickRow( int row )
	  * helper function to create a row of bricks
	  * depends calls on getBrick helper function
	  */
	 private void setBrickRow( int curRow ){
		
		//get row height: offset + (number of rows above * brick height and row separation)
		int curY = BRICK_Y_OFFSET + ( curRow *  (BRICK_HEIGHT + BRICK_SEP) );
		//get color:
		Color curColor = getRowColor( curRow ); 
		assert(curColor != null);
		//loop and a half logic
		//set brick; increment brick; check brickCount ; add sep
		int brickInd = 0;
		int sep = 0;
		while(true){
			//set brick: get x ;  
			int curX = brickInd * (BRICK_WIDTH) + sep;
			GRect curBrick = getBrick( curX, curY, curColor);
			add( curBrick);
			brickInd++;
			//check if surpassed number of bricks
			if(brickInd >= NBRICKS_PER_ROW){
				break;
			}
			sep = brickInd * BRICK_SEP;
		}
	 }
	 
	 /**
	  * getRowColor:
	  * encapsulation of logic for figuring out the row color
	  */
	 private Color getRowColor( int row ){
		 
		 int curCase = row / N_ROWS_PER_COLOR;
		 
		 switch( curCase ){
		 	case 0:
		 		return Color.RED;
		 	case 1:
		 		return Color.ORANGE;
		 	case 2:
		 		return Color.YELLOW;
		 	case 3:
		 		return Color.GREEN;
		 	case 4:
		 		return Color.CYAN;
		 	default:
		 		System.out.println("exceeded number of colors expected in getRowColor logic.");
		 		System.out.println("returning null.");
		 		return null;
		 }		  
	 }
	 /**
	  * getBrick()
	  * helper function for setBrickRow. Returns a GRect of specified location, size, and color
	  * @param xLoc
	  * @param yLoc
	  * @param curCol
	  * @return GRect
	  */
	 private GRect getBrick(double xLoc , double yLoc , Color curCol){
		 GRect curBrick = new GRect(xLoc, yLoc , BRICK_WIDTH, BRICK_HEIGHT);
		 curBrick.setColor( curCol );
		 curBrick.setFillColor(curCol);
		 curBrick.setFilled(true);
		 return curBrick;
	 }
	 
	 private void setPaddle(){
		 
	 }
	 
	 private void setBall(){
		 
	 }
	 
	 public void keyPressed( KeyEvent e ){
		 keyPressed = e.getKeyChar();
		 
	 }
	 
	 //instance variables
	 GRect paddle;
	 GOval ball;
	 //for getting initial random x direction
	 RandomGenerator rgen = RandomGenerator.getInstance();
	 char keyPressed;

}