package CS106A;
import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class assignment_2 extends GraphicsProgram{
	
	//define constants
	private static final double HEAD_WIDTH = 20.0;
	private static final double HEAD_HEIGHT = 20.0;
	private static final double CANVAS_WIDTH = 500;
	private static final double CANVAS_HEIGHT = 500;
	
	public void run(){
		// TODO Auto-generated method stub
		//FIBONACCI PART
		//System.out.println("curFib");
		//sequentialFib(1000);
		//END FIBONACCI PART
		
		//CANVAS PART
		int canvasHeight = getHeight();
		int canvasWidth = getWidth();
		
		add( drawHead(canvasWidth, canvasHeight) );
		//add eye balls
		GOval leftEye = makeCircle( )
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("curFib");
//		sequentialFib(1000);
//		add( drawAFace() );
//	}
	
	/*
	 * fib()
	 * take integer and print all fibonacci numbers up to that number
	 * input: integer curNum
	 * output: print numbers
	 * 
	 * TO FIX: USE WHILE LOOP FOR CURTERM
	 */
	private static void sequentialFib( int limit ){
		System.out.println("This program lists the fibonacci sequence");
		
		//basecase 0 and 1
		int lastLastFib = 0;
		int lastFib = 1;
		System.out.println( lastLastFib );
		System.out.println( lastFib );
		for( int i = 2; i < limit ; i++){
			//increase curFib by value of i - 1
			int curFib = lastFib + lastLastFib;
			//don't exceed 10000
			if(curFib > 10000){
				System.out.println("exceeding limit: 10000. Breaking");
				break;
			}
			//print curFib
			System.out.println(curFib);
			//assign new values
			lastLastFib = lastFib;
			lastFib = curFib;
		}
	}
	
	private static int recursiveFib( int curNum ){
		
		//edge case (passing negative)
		if( curNum < 0){
			System.out.println(" passed number less than 0. ");
			return -1;
		}
		//basecase i <= 1 (0 or 1) --> return i
		if( curNum < 1){
			return curNum;
		}
		
		//compute fib of last 2 numbers
		int last = recursiveFib( curNum - 1 );
		int lastLast = recursiveFib( curNum - 2);
		
		//return sum of the two
		return last + lastLast;
	}
	
	/*
	 * drawAFace()
	 * draw a robots face that consists of a rectangular head, 2 yellow eyes, and a moth
	 * 
	 * @parameters: HEAD_WIDTH, HEAD_HEIGHT, EYE_RADIUS, MOUTH_WIDTH, MOUTH_RADIUS
	 * 
	 * Head Description: interior is gray, frame is black
	 * 					 centered in the middle of the graphics window
	 * 
	 * 
	 * Eyes: set a quarter of a HEAD_WIDTH apart from each other
	 * 		 set one quarter of a HEAD_HEIGHT from the top of the head
	 * 		 color yellow
	 * 
	 * Mouth: centered with respect to HEAD_WIDTH and a quarter HEAD_HEIGHT up from the bottom of the head
	 *        a white open rectangle
	 * 
	 * Temp Notes:
	 * 1. Trying to make GCanvas object as opposed to extending entire GraphicsProgram 
	 * 2. If doesn't work then need to extend GraphicsProgram class
	 * 
	 * 
	 */
	private static GRect drawHead(int canvasWidth, int canvasHeight){
		
		//make grect
		GRect robotHead = new GRect(HEAD_WIDTH, HEAD_HEIGHT, canvasWidth/2 , canvasHeight/2 );
		//set fill color
		robotHead.setFillColor(Color.GRAY);
		//need to set filled
		robotHead.setFilled(true);
		return robotHead;
		
	}
	
	private static GOval makeCircle(double radius, Color col){
		GOval curCircle = new GOval( radius, radius);
		//asert that col is a color
		if( !( col == null) ) {
			curCircle.setFillColor(col);
			curCircle.setFilled(true);
		}
		return curCircle;
	}
	
	
	
}
