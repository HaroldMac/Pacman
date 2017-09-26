/** 
 * creates a pacman on board as well as all the rules for pacman
 * 
 * @author Neil Pohlman, Harold MacDonald, Mubeen Khalid, Justin Currie Leslie
 * @version Final Project Dec 4, 2014
 */



import java.awt.Color;
import java.awt.Graphics;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class User extends GameObject {
	
	private String type = "USER";
	private int lives = 3;
	private int score = 0;
	private int counter = 1;
	private boolean ateByGhost = false;

	/** 
	 * gets starting x and y coordinates for pacman
	 * @param starting x coordinate
	 * @param starting y coordinate
	 */

	public User (int startXCord, int startYCord){
		super(startXCord, startYCord);
	}
	
	public int getLives(){return lives;}
	public int getScore(){return score;}
	public void openMouth(){counter = 1;}
	public boolean getAteByGhost(){return ateByGhost;}
	public void setAteByGhost(boolean value){ateByGhost = value;}
	
	/** 
	 * deals with loss of life, plays sound as well as removes life from lives variable
	 */    

	public void lossLife(){
		lives = lives - 1;
		counter = 1;
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File("sound/ghost.wav")));
			clip.start();
			Thread.sleep(1000);
		} catch(Exception ex) {System.out.println("File ghost.wav not found.");}
	}
	
	/** 
	 * adds ponts to score as well as plays eating sound 
	 * @param nextMove, looks at pacmans next move
	 */

	public void addPoints(String nextMove){
		if (nextMove == "[P]"){
				score = score + 10;
			try {
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(new File("sound/eat.wav")));
				clip.start();
			} catch(Exception ex) {}
		}
	}
	
	public void addPoints(Point aPoint){
		score = score + aPoint.getPointValue();
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File("sound/eat.wav")));
			clip.start();
		} catch(Exception ex) {System.out.println("File eat.wav not found.");}
	}
	
	
	
	/** 
	 * takes the move and changes pacmans x and y coordinates 
	 * @param move, the move that is dealt with, during the keylistner
	 */
	public  void  playerMove(String move){
		switch (move){
			case "u":
			case "Up":
					setYCord(getYCord() - 1);
				break;
			case "d":
			case "Down":
					setYCord(getYCord() + 1);
				break;
			case "l":
			case "Left":
					setXCord(getXCord() - 1);
				break;
			case "r":
			case "Right":
					setXCord(getXCord() + 1);
				break;
		}
	}
	
	String draw(){
		return "[<]";
	}
	

    	/** 
	 * houses all the information for drawing pacman as well as opens and closes his mouth on a counter
	 * @param Graphics g
	 */

	public void draw(Graphics g){
		counter ++;
		g.setColor(Color.YELLOW);
		g.fillOval(this.getXCord()*20, this.getYCord()*20, 16, 16);
		g.setColor(Color.black);
		
		//Flips the output image to make mouth appear to open anc close.
		if ((counter % 2)== 0){
			g.fillArc(this.getXCord()*20-2, this.getYCord()*20, 20, 20,0,40);
		}
		g.fillOval(this.getXCord()*20+5, this.getYCord()*20+2, 4, 4);
		
	}
}
