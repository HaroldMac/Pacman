/** 
 * this is out class for game objects
 * 
 * @author Neil Pohlman, Harold MacDonald, Mubeen Khalid, Justin Currie Leslie
 * @version final version Dec 4, 2014
 */


import java.awt.Color;
import java.awt.Graphics;

public class GameObject {
	
	private int xCord, yCord;
	private String type = "NULL";
	
	public GameObject(){
		this(0,0);
	}
	 /** 
	 * sets x and y coordinates for game objects
	 * @param takes starting x coordinate
	 * @param takes starting y coordinate
	 */

	public GameObject(int startXCord, int startYCord){
		setXCord(startXCord);
		setYCord(startYCord);
	}
	
	//Setter methods
	public void setXCord(int newXCord){xCord = newXCord;}
	public void setYCord(int newYCord){yCord = newYCord;}

	
	//Getter methods
	public int getXCord(){return xCord;}
	public int getYCord(){return yCord;}
	public String getType(){return type;}

	/** 
	 * draw method for walls
	 * @return [ ] to indicate a wall
	 */

	String draw(){
		return "[ ]";
	}

	/** 
	 * sets the color and size for the walls
	 */

	public void draw(Graphics g){
		g.setColor(Color.black);
		g.fillRect(this.getXCord() * 20, this.getYCord()* 20, 20, 20);
	}
	
}

 

