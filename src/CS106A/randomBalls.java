package CS106A;

//import necessary packages
import acm.graphics.*; //graphics packages to get graphics objects
import acm.program.*; // program packages to create a Graphics program
import acm.util.*;	 // util for random Generator
import java.awt.*;   // get Color object
import java.util.concurrent.TimeUnit;

/**
 * Create a graphics program that generates NUM_BALLS random balls of random size, color and location
 * @author XaviGuitart
 *
 */
public class randomBalls extends GraphicsProgram {

	/*
	 * constants: 
	 * 1. NUM_BALLS : total number of balls
	 * 2. MIN_RAD   : minimum radius of balls
	 * 3. MAX_RAD   : max radius of balls
	 */
	private static final int NUM_BALLS = 10;
	private static final int MIN_RAD = 2;
	private static final int MAX_RAD = 20;
	
	/*
	 * Algorithm:
	 * 1.) make ball
	 */
	
	public void run(){
		
		canvasWidth = getWidth();
		canvasHeight = getHeight();
		
		//get sense of the canvas size
		GRect canvasBorder = new GRect(canvasWidth, canvasHeight);
		add(canvasBorder);
		
		for( int i = 0 ; i < NUM_BALLS ; i++){
			//get radius
			ballSize  = rgen.nextInt(MIN_RAD, MAX_RAD);
			ballDiam = ballSize * 2;
			
			//get limit
			rightLimit = canvasWidth - ballDiam;
			bottomLimit = canvasHeight - ballDiam;
			
			//pass radius as left limit and rightLimit + 1 because not inclusive
			int xPoint = rgen.nextInt(0, rightLimit + 1);
			int yPoint = rgen.nextInt(0, bottomLimit + 1);
			
			//get color
		    Color col = rgen.nextColor();
		    
		    //make and add ball
		    add( getBall( xPoint, yPoint, ballSize, col) );
		}
		
	}
	
	/*
	 * getBall( radius )
	 * get a ball of size radius and return the ball
	 */
	private GOval getBall(double curX, double curY, double curRad, Color curColor){
		//double the radius to get diameter
		GOval curBall = new GOval(curRad * 2, curRad * 2);
		curBall.setLocation(curX, curY);
		curBall.setFillColor( curColor );
		curBall.setFilled(true);
		return curBall;
	}
	
	/*
	 * private instance vars:
	 */
	RandomGenerator rgen = RandomGenerator.getInstance(); //look into this because you don't get it
	int canvasWidth;
	int canvasHeight;
	int rightLimit;
	int bottomLimit;
	int ballSize;
	int ballDiam;
}
