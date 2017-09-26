/** 
 * this code implements our graphics
 * 
 * @author Neil Pohlman, Harold MacDonald, Mubeen Khalid, Justin Currie Leslie
 * @version demo 3 Nov 18, 2014
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class GameGui extends JPanel  {
	
	Controller control;
	private GameConfiguration game;
	
	public GameGui(Controller controller) {
		
		addKeyListener(controller);
		control = controller;
		game = controller.getGameConfig();
		
		setFocusable(true);
        setBackground(Color.black);
        setBorder(BorderFactory.createLineBorder(Color.gray));

	}

    	/** 
	 * intro screen for the game
	 * @param canvas
	 */
	private void introScreen(Graphics canvas){
		
		canvas.setColor(Color.YELLOW);
		canvas.setFont(new Font("TimesRoman", Font.PLAIN, 55)); 
        canvas.drawString("PACMAN", 90, 155);
        control.playStart();
        
        canvas.setFont(new Font("TimesRoman", Font.PLAIN, 18)); 
        canvas.drawString("Press an arrow key to continue", 95, 245 );
        User dummyUser	  = new User(10, 15);
        Ghost dummyGhost1 = new Ghost(9, 15, 1);
        Ghost dummyGhost2 = new Ghost(11, 15, 2);
        Ghost dummyGhost3 = new Ghost(10, 14, 3);
        Ghost dummyGhost4 = new Ghost(10, 16, 4);
		dummyUser.draw(canvas);
		dummyGhost1.draw(canvas);
		dummyGhost2.draw(canvas);
		dummyGhost3.draw(canvas);
		dummyGhost4.draw(canvas);
    }
    	/** 
	 * drawing method
	 * @param canvas
	 */
	public void paint(Graphics canvas) {
		super.paint(canvas);
		

		if (control.getIntro()){	
			introScreen(canvas);
			
		} else {
			drawBoard(canvas);
			game.getUser().draw(canvas);
			game.getGhost1().draw(canvas);
			game.getGhost2().draw(canvas);
			game.getGhost3().draw(canvas);
			game.getGhost4().draw(canvas);
			score(canvas);
			life(canvas);
		}
		if (control.getLose()){loss(canvas);}
		if (control.getWin()) {win (canvas);}

	}
	
	public void drawBoard(Graphics canvas){
		for (int i = 0; i < game.getBoardSize(); i++){
			for (int j = 0; j < game.getBoardSize(); j++){
				GameObject sprite = game.getGameBoardElement(i,j);
				sprite.draw(canvas);
			}
		}
	}
	
	 /** 
	 * draws and updates the score
	 * @param canvas
	 */
	public void score(Graphics canvas){
		canvas.setColor(Color.white);
		canvas.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		String score = "Score: " + game.getUser().getScore();
        canvas.drawString(score, 250, 435);
	}

	 /** 
	 * number of lives left gui
	 * @param canvas
	 */

	public void life(Graphics canvas){
		for (int i = 0; i < game.getUser().getLives(); i++){
				User dummy = new User(2 + i, 21);
				dummy.draw(canvas);
		}
	}
	
	/** 
	 * the winning screen, if you collect all points
	 * @param canvas
	 */

	public void win(Graphics canvas){
		canvas.setColor(Color.white);
		canvas.setFont(new Font("TimesRoman", Font.PLAIN, 45)); 
        canvas.drawString("YOU WIN!!!!", 85, 215);
        game.getUser().openMouth();
		control.stopTimer();
		repaint();	
	}

	/** 
	 * the lossing screen, if you run out of lives
	 * @param canvas
	 */

	public void loss(Graphics canvas){
		canvas.setColor(Color.white);
		canvas.setFont(new Font("TimesRoman", Font.PLAIN, 45)); 
        canvas.drawString("YOU LOSE!!!!", 75, 215);
        game.getUser().openMouth();
        control.stopTimer();
		repaint();
	}

	/** 
	 * handles keyboard event for all arrow keys
	 * @param evt, the event happening on the keyboard
	 * @return updates the players move (u1)
	 */    

	
}
