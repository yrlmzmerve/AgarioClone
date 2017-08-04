package tr.org.linux.kamp.Agario.view;

import javax.swing.JFrame;

/**
 * 
 * @author MerveY
 * @version 1.0
 * A JFrame class that provide create a frame for game board
 */

public class GameFrame extends JFrame {
	
	public GameFrame() {
		
		// TODO Auto-generated constructor stub
		setTitle("Agario Clone");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,480);
		setLocationRelativeTo(null);
		//setVisible(true);
		
	}

}
