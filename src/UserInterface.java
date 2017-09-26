/** 
 * seperate class to create jframe
 * 
 * @author Neil Pohlman, Harold MacDonald, Mubeen Khalid, Justin Currie Leslie
 * @version Final Project Dec 4, 2014
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;


// sets all the paramaters for the jframe
public class UserInterface extends JFrame{
	
	public UserInterface(GameConfiguration game) {
		
		Controller control = new Controller(game);
		add(control.getGui(), BorderLayout.CENTER);
		setTitle("PACMAN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(425, 480);
        setLocationRelativeTo(null);
        setVisible(true);        
        setResizable(false);
    }

}
	
