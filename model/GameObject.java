package tr.org.linux.kamp.Agario.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * @author MerveY
 * @version 1.0
 * A generic abstract class that can produce an enemy, a mine, a chip and a player.
 *
 */

public abstract class GameObject {
	private int x;
	private int y;
	private int radius;
	private Color color;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 * @param color
	 */
		
	public GameObject(int x, int y, int radius, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}
	
	/**
	 * A drawing method to draw with setting color and filling via fields.
	 * @param g2d
	 */
	
	public void draw(Graphics2D g2d) {
		
		g2d.setColor(getColor());
		g2d.fillOval(getX(), getY(), getRadius(), getRadius());
	}
	
	/**
	 * Gets rectangle to scale collision
	 * 
	 * @return A rectangle object with fields x,y and radius
	 */
	
	public Rectangle getRectangle() {
		Rectangle rect = new Rectangle(getX(), getY(), getRadius(), getRadius());
		return rect;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
