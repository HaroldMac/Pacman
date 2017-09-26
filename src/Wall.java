/** 
 * this class if for the walls
 * 
 * @author Neil Pohlman, Harold MacDonald, Mubeen Khalid, Justin Currie Leslie
 * @version Final Project Dec 4, 2014
 */

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends GameObject {

	private String type = "WALL";
	
	/** 
	 * gets starting x and y coordinates for the point 
	 * @param starting x coordinate
	 * @param starting y coordinate
	 */

	public Wall (int startXCord, int startYCord){
		super(startXCord, startYCord);		
	}
	
	public String getType() {return type;}
	
	String draw(){
		return "XXX";
	}
	
	/** 
	 * contains all the information about drawing the walls
	 * @param Graphics g
	 */

	public void draw(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(this.getXCord() * 20, this.getYCord()* 20, 18, 18);
	}
}
