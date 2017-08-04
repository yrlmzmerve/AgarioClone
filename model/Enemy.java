package tr.org.linux.kamp.Agario.model;

import java.awt.Color;

/**
 * 
 * @author MerveY
 * @version 1.0
 * A generic enemy class that extends from Game Objects abstract class.
 */

public class Enemy extends GameObject {

	private int speed;
/** 
 * @param x
 * @param y
 * @param radius
 * @param speed
 * @param color
 */
	public Enemy(int x, int y, int radius, int speed, Color color) {
		super(x, y, radius, color);
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
/**
 * Sets param between 5-250
 * @param radius
 * 
 */
	@Override
	public void setRadius(int radius) {
		// TODO Auto-generated method stub
		super.setRadius(radius);
		if (getRadius() < 5)
			setRadius(5);

		else if (getRadius() > 250)
			setRadius(250);

	}

}
