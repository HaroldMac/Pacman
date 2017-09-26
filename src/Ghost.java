/** 
 * AI - creates random move for AI and checks if valid 
 * 
 * @author Neil Pohlman, Harold MacDonald, Mubeen Khalid, Justin Currie Leslie
 * @version Final Version  Dec 4, 2014
 */


import java.util.Random;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.*;

public class Ghost extends GameObject {

	private String type = "GHOST";
	private String lastPosition = "[P]";
	private String lastMove = "D";
	private String chasingMove ="null";
	private Color aColor = Color.red;
	
	/** 
	 * gets ghost starting x and y coordinates
	 * @param  x coordinate of ghost
	 * @param y coordinate of ghost
	 */

	public Ghost (int startXCord, int startYCord){
		super(startXCord, startYCord);
	}

	/** 
	 * sets ghost colors
	 * @param ghost starting x coordinate
	 * @param ghost starting y coordinate
	 * @param ghosts identification number between 1-4
	 */

	public Ghost (int startXCord, int startYCord, int ghostNumber){
		super(startXCord, startYCord);
		
		if (ghostNumber > 4 || ghostNumber < 1){ ghostNumber = 1;}
		switch(ghostNumber){
			case 1: 
				aColor = Color.red;
				break;
			case 2: 
				aColor = Color.blue;
				break;
			case 3: 
				aColor = Color.green;
				break;
			case 4: 
				aColor = Color.pink;
				break;
		}
	}
	
	public String getLastMove(){return lastMove;}
	public void   setLastMove(String newLastMove){lastMove = newLastMove;}
		
	/** 
	 * Array list used because size of list can very. For instance, if the ghost
	 * is on the top row, then a list of only 3 moves is needed. If the ghost is
	 * in a corner, then only 2 moves are needed.
	 * Makes a list of available moves
	 * @param gets the coordinates for up
	 * @param gets the coordinates for down
	 * @param gets the coordinates for left
	 * @param gets the coordinates for right
	 * @return lists of move options available 
	 */

	public String getMove(GameObject up, GameObject down, GameObject left, GameObject right){
		
		Random generator = new Random();
		
		//Array list used because size of list can very. For instance, if the ghost
		//is on the top row, then a list of only 3 moves is needed. If the ghost is
		//in a corner, then only 2 moves are needed.
		//Makes a list of available moves.
		
		ArrayList<String> availableMoves = new ArrayList<String>();
		if (up.getType()    != "WALL"  && (lastMove == "U"  || lastMove == "R" || lastMove == "L")){availableMoves.add("U");}
		if (down.getType()  != "WALL"  && (lastMove == "D"  || lastMove == "R" || lastMove == "L")){availableMoves.add("D");}
		if (left.getType()  != "WALL"  && (lastMove == "L"  || lastMove == "U" || lastMove == "D")){availableMoves.add("L");}
		if (right.getType() != "WALL"  && (lastMove == "R"  || lastMove == "U" || lastMove == "D")){availableMoves.add("R");}

		//pick a random direction from the list of moves, and remember that direction.
		int i = generator.nextInt(availableMoves.size());
		lastMove = availableMoves.get(i);
		
		return availableMoves.get(i);
	}
	
    	/** 
	 * ghost move 
	 */
    
	public void ghostMove(String move){
		
		switch (move){
			case "u":
			case "U":
				this.setYCord(this.getYCord() - 1);
				break;
			case "d":
			case "D":
				this.setYCord(this.getYCord() + 1);
				break;
			case "l":
			case "L":
				this.setXCord(this.getXCord() - 1);
				break;
			case "r":
			case "R":
				this.setXCord(this.getXCord() + 1);
				break;
			default:
				System.out.println("Invalid Move");
				break;
		}
	}
	
	String draw(){
		return "[G]";
	}
	
	/** 
	 * draws the ghost
	 * @param graphics g
	 */

	public void draw(Graphics g){
		g.setColor(aColor);
		g.fillRect(this.getXCord() * 20+5, this.getYCord()* 20+6, 10, 10);
		g.fillOval(this.getXCord() * 20+4, this.getYCord()* 20, 10, 10);
		g.setColor(Color.white);
		g.fillOval(this.getXCord() * 20+5, this.getYCord()* 20+3, 3, 3);
		g.fillOval(this.getXCord() * 20+8, this.getYCord()* 20+3, 3, 3);
	}
}
