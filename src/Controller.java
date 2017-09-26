/** 
 * Controller class, handles key inputs as well as a timer
 * This class was added as discussed in demo 3
 * 
 * @author Neil Pohlman, Harold MacDonald, Mubeen Khalid, Justin Currie Leslie
 * @version final project December 4th
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Controller implements KeyListener {


	private GameConfiguration thisGame;	
	private GameGui gui;

	private boolean intro, win, lose, step;
	private String u1Move = "Down";

	private Timer timer;
	private ActionListener action ;	
	
	public GameGui getGui(){return gui;}
	public GameConfiguration getGameConfig(){return thisGame;}
	public boolean getIntro(){return intro;}
	public boolean getWin(){return win;}
	public boolean getLose(){return lose;}
	public void stopTimer(){timer.stop();}

public Controller(GameConfiguration game) {
		
		thisGame = game;
		gui = new GameGui(this);
		
		intro = true;
		win = false;
		lose = false;
		step = true;
				
		
        timer = new Timer(200, new ActionListener() {  
			
            public void actionPerformed(ActionEvent ae) {
				if (step){
					thisGame.step(u1Move);
					step = false;
				} else {
					thisGame.step2();
					step = true;
				}
				if (thisGame.getUser().getAteByGhost()){
					u1Move = "Down";
					if (thisGame.getUser().getLives() != 0){
						timer.stop();
					}
				}
				if (thisGame.getLost()){lose = true;}
				if (thisGame.getWon()){win = true;}
				gui.repaint();
			}});
		timer.setCoalesce(false);
	}

   	 /** 
	 * plays the game sound
	 */
	public void playStart(){
		File startSong = new File("sound/start.wav");
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(startSong));
			clip.start();
		} catch(Exception ex) {System.out.println("File start.wav not found.");}
	}

	/** 
	 * Takes user input
	 * @param evt takes what the users input is
	 * @return updates the move of the user
	 *///keyboard event handlers
	public void keyPressed(KeyEvent evt){
			
		switch(evt.getKeyCode()) {
		case (KeyEvent.VK_LEFT):
				u1Move = "Left";
			break;
		case (KeyEvent.VK_RIGHT):
				u1Move = "Right";
			break;
		case (KeyEvent.VK_DOWN):
				u1Move = "Down";
			break;
		case (KeyEvent.VK_UP):
				u1Move = "Up";
			break;
		default :
			u1Move = "invalid";
			break;
		}
		if (evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT || evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
			thisGame.getUser().setAteByGhost(false);
			if (intro)	{intro = false;} 
			timer.start();
		}
	}
	
	public void keyReleased(KeyEvent evt){}
	public void keyTyped(KeyEvent evt){}	
}
