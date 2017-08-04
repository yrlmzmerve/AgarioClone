package tr.org.linux.kamp.Agario.model;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * @author MerveY
 * @version 1.0	
 * A generic player class that extends from Game Objects abstract class.
 *
 */
public class Player extends GameObject {
	
	private int speed;
	private BufferedImage image;
	private String name;
	
	/**
	 * @param x
	 * @param y
	 * @param radius
	 * @param color
	 * @param speed
	 * @param name
	 */

	public Player(int x, int y, int radius, Color color, int speed, String name) {
		super(x, y, radius, color);
		this.speed=speed;
		this.name=name;
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Player objects's shape property
	 * 
	 */
	
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		super.draw(g2d);
		g2d.setColor(Color.pink);
		FontMetrics fontMetrics = g2d.getFontMetrics(g2d.getFont());
		int width = fontMetrics.stringWidth(name);
		int nameX = getX() + (getRadius()-  width)/2;
		int nameY = getY() -fontMetrics.getHeight();

		g2d.drawString(name, nameX, nameY);
		//g2d.drawImage(image, getX(), getY(), getRadius(), getRadius(), null);
}
	
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 *  Sets param between 5-250
	 *  @param radius
	 * 
	 */
	
	@Override
	public void setRadius(int radius) {
		// TODO Auto-generated method stub
		super.setRadius(radius);
		if(getRadius() <5)
			setRadius(5);
		
		else if(getRadius() >250)
			setRadius(250);
	}
	

}
