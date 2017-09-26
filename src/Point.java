/** 
 * this class is for the points, the yellow dots pacman eats
 * 
 * @author Neil Pohlman, Harold MacDonald, Mubeen Khalid, Justin Currie Leslie
 * @version Final Project Dec 4, 2014
 */


import java.awt.Graphics;
import java.awt.Color;

public class Point extends GameObject {
	
	private String type = "POINT";
	private int pointValue = 10;
	
	/** 
	 * gets starting x and y coordinates for the point 
	 * @param starting x coordinate
	 * @param starting y coordinate
	 */

	public Point(int startXCord, int startYCord){
		super(startXCord, startYCord);
	}
	
    	/** 
	 * creates new points for all the points on the board
	 * @param aPoint
	 */

	public Point(Point aPoint){
		Point newPoint = new Point(aPoint.getXCord(), aPoint.getYCord());
		
		
	}
	
	public String getType() {return type;}
	public int getPointValue() {return pointValue;}

	
	String draw(){
		return "[P]";
	}
	
	/** 
	 * contains all the information about drawing the point
	 * @param Graphics g
	 */

	public void draw(Graphics g){
		g.setColor(Color.orange);
		g.fillOval(this.getXCord()*20 + 5, this.getYCord()*20 + 5, 8, 8);
	}

}
