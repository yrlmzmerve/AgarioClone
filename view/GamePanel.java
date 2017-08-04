package tr.org.linux.kamp.Agario.view;

/*
 * mvc - model view control
 * contoller 
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import tr.org.linux.kamp.Agario.model.GameObject;

/**
 * 
 * @author MerveY
 * @version 1.0 A JPanel class that provide create a frame above a frame
 */
public class GamePanel extends JPanel {

	private ArrayList<GameObject> gameObject;

	public GamePanel(ArrayList<GameObject> gameObject) {

		this.gameObject = gameObject;

	}
	/*
	 * synchronized thread : for same time works
	 */

	@Override
	protected synchronized void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		for (GameObject gameObject2 : gameObject) {
			gameObject2.draw(g2d);
		}

	}

}
