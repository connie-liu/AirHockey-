//Name -
//Date -
//Class -
//Lab  - 

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
	//instance variables
	private int speed;

	public Paddle()
	{
		super(10,10);
		speed = 5;
	}
	//add the other Paddle constructors
	public Paddle(int x, int y)
	{
		super(x,y);
		speed = 5;
	}
	public Paddle(int x, int y, int s)
	{
		super(x, y);
		speed = s;
	}
	public Paddle(int x, int y, int wid, int h, int s)
	{
		super(x, y, wid, h);
		speed = s;
	}
	public Paddle(int x, int y, int wid, int h, Color col, int s)
	{
		super(x, y, wid, h, col);
		speed = s;
	}

	public void moveUpAndDraw(Graphics window)
	{
		window.setColor(Color.white);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
		setY(getY()-getSpeed());
		window.setColor(getColor());
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void moveDownAndDraw(Graphics window)
	{
		window.setColor(Color.white);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
		setY(getY()+getSpeed());
		window.setColor(getColor());
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void moveLeftAndDraw(Graphics window)
	{
		window.setColor(Color.white);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
		setX(getX()-getSpeed());
		window.setColor(getColor());
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void moveRightAndDraw(Graphics window)
	{
		window.setColor(Color.white);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
		setX(getX()+getSpeed());
		window.setColor(getColor());
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	//add get methods
	public int getSpeed()
	{
		return speed;
	}

	//add a toString() method
	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getSpeed();
	}
}