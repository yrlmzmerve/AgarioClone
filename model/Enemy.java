package tr.org.linux.kamp.Agario.model;

import java.awt.Color;

public class Enemy extends GameObject {

	private int speed;

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
